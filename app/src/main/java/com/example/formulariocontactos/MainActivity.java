package com.example.formulariocontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    String fecha;
    private TextInputEditText textNombre;
    private TextInputEditText textCorreo;
    private TextInputEditText textTelefono;
    private TextInputEditText textDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView2);
        textNombre=findViewById(R.id.textNombre);
        textDescripcion=findViewById(R.id.textDescripcion);
        textTelefono=findViewById(R.id.textTelefono);
        textCorreo=findViewById(R.id.textEmail);
        fecha="";

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                fecha= year+"/"+ (month+1)+"/"+dayOfMonth;
            }
        });
        editarDatos();
    }

    public void mandarDatos(View view){
        String nombre,descripcion,telefono,correo;
        nombre=textNombre.getText().toString();
        telefono=textTelefono.getText().toString();
        correo=textCorreo.getText().toString();
        descripcion=textDescripcion.getText().toString();
        if(nombre.equals("")){
            Toast.makeText(getBaseContext(),"Escriba Nombre",Toast.LENGTH_SHORT).show();
        }else{
            if(telefono.equals("")){
                Toast.makeText(getBaseContext(),"Escriba Telefono",Toast.LENGTH_SHORT).show();
            }else{
                if(correo.equals("")){
                    Toast.makeText(getBaseContext(),"Escriba Correo",Toast.LENGTH_SHORT).show();
                }else{
                    if(fecha.equals("")){
                        Toast.makeText(getBaseContext(),"Seleccione Fecha de Nacimiento",Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(getBaseContext(),correo,Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,ConfirmarDatos.class);
                        intent.putExtra(getResources().getString(R.string.pnombre),nombre);
                        intent.putExtra(getResources().getString(R.string.ptelefono),telefono);
                        intent.putExtra(getResources().getString(R.string.pemail),correo);
                        intent.putExtra(getResources().getString(R.string.pfecha),fecha);
                        intent.putExtra(getResources().getString(R.string.pdescripcion),descripcion);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }
    }

    public void editarDatos(){
        try{
            Bundle parametros=getIntent().getExtras();
            textNombre.setText(parametros.getString(getResources().getString(R.string.pnombre)));
            textTelefono.setText(parametros.getString(getResources().getString(R.string.ptelefono)));
            textCorreo.setText(parametros.getString(getResources().getString(R.string.pemail)));
            textDescripcion.setText(parametros.getString(getResources().getString(R.string.pdescripcion)));
            fecha=parametros.getString(getResources().getString(R.string.pfecha));
            calendarView.setDate(new SimpleDateFormat("yyyy/MM/dd").parse(fecha).getTime(), true, true);

        }catch (Exception e){

        }

    }

}