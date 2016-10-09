package com.example.javier.abmcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Actividad2 extends AppCompatActivity {

    TextView tvNombre,tvTelefono,tvEmail,tvDesc,tvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        tvNombre=(TextView)findViewById(R.id.tvNombreCampo);
        tvTelefono=(TextView)findViewById(R.id.tvTelefonoCampo);
        tvEmail=(TextView)findViewById(R.id.tvEmailCampo);
        tvDesc=(TextView)findViewById(R.id.tvDescCampo);
        tvFecha=(TextView) findViewById(R.id.tvFechaCampo);

        Intent intent=getIntent();
        Bundle par =intent.getExtras();

        if (par != null) {

            String datoNombre=par.getString("nombre");
            String datoTelefono=par.getString("telefono");
            String datoEmail=par.getString("eMail");
            String datoDesc=par.getString("desc");
            String datoFecha=par.getString("fecha");

            tvNombre.setText(datoNombre);
            tvTelefono.setText(datoTelefono);
            tvEmail.setText(datoEmail);
            tvDesc.setText(datoDesc);
            tvFecha.setText(datoFecha);
        }
    }
}
