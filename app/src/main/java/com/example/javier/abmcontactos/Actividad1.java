package com.example.javier.abmcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class Actividad1 extends AppCompatActivity {

    //Variables a pasar
    private EditText nombre;
    private EditText telefono;
    private EditText eMail;
    private EditText desc;
    //Botón
    private Button boton;
    private DatePicker fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        //Recuperamos los valores
        nombre=(EditText)findViewById(R.id.campoNombre);
        telefono=(EditText)findViewById(R.id.campoTelefono);
        eMail=(EditText)findViewById(R.id.campoMail);
        desc=(EditText)findViewById(R.id.campoDesc);
        fecha=(DatePicker)findViewById(R.id.campoFecha);

        //Buscamos el boton
        boton=(Button)findViewById(R.id.botonSiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutar(v);
            }
        });
    }
    public void ejecutar(View view){

        Intent i=new Intent(this,Actividad2.class);

            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("telefono",telefono.getText().toString());
            i.putExtra("eMail",eMail.getText().toString());
            i.putExtra("desc",desc.getText()).toString();
            i.putExtra("fecha",fecha.getDayOfMonth()).toString();

        startActivity(i);
    }
}
