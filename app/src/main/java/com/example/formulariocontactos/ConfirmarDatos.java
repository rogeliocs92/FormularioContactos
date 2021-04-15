package com.example.formulariocontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView textNombre;
    private TextView textCorreo;
    private TextView textTelefono;
    private TextView texteFecha;
    private TextView textDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_datos);
        Bundle parametros=getIntent().getExtras();

        textNombre=findViewById(R.id.mNombre);
        textCorreo=findViewById(R.id.mCorreo);
        textTelefono=findViewById(R.id.mTelefono);
        texteFecha=findViewById(R.id.mFecha);
        textDescripcion=findViewById(R.id.mDescrip);


        textNombre.setText(parametros.getString(getResources().getString(R.string.pnombre)));
        textTelefono.setText(parametros.getString(getResources().getString(R.string.ptelefono)));
        textCorreo.setText(parametros.getString(getResources().getString(R.string.pemail)));
        texteFecha.setText(parametros.getString(getResources().getString(R.string.pfecha)));
        textDescripcion.setText(parametros.getString(getResources().getString(R.string.pdescripcion)));
    }

    public void editarDatos(View view){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre),textNombre.getText());
        intent.putExtra(getResources().getString(R.string.ptelefono),textTelefono.getText());
        intent.putExtra(getResources().getString(R.string.pemail),textCorreo.getText());
        intent.putExtra(getResources().getString(R.string.pfecha),texteFecha.getText());
        intent.putExtra(getResources().getString(R.string.pdescripcion),textDescripcion.getText());
        startActivity(intent);
    }
}