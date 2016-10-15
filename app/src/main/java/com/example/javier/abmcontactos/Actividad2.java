package com.example.javier.abmcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Actividad2 extends AppCompatActivity {

    TextView tvNombre,tvTelefono,tvEmail,tvDesc,tvFecha;
    private int intDia, intMes, intAño;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        Intent intent=getIntent();
        Bundle par =intent.getExtras();

        if (par != null) {


            tvNombre=(TextView)findViewById(R.id.tvNombreCampo);
            tvTelefono=(TextView)findViewById(R.id.tvTelefonoCampo);
            tvEmail=(TextView)findViewById(R.id.tvEmailCampo);
            tvDesc=(TextView)findViewById(R.id.tvDescCampo);
            tvFecha=(TextView) findViewById(R.id.tvFechaCampo);


            String datoNombre=par.getString("nombre");
            String datoTelefono=par.getString("telefono");
            String datoEmail=par.getString("eMail");
            String datoDesc=par.getString("descripcion");
            String datoFecha=par.getString("fecha");

            intAño = par.getInt(getString(R.string.pFecha_nacimientoYear));
            intDia = par.getInt(getString(R.string.pFecha_nacimientoDay));
            intMes = par.getInt(getString(R.string.pFecha_nacimientoMonth));

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, intAño);
            cal.set(Calendar.DAY_OF_MONTH, intDia);
            cal.set(Calendar.MONTH, intMes);
            String format = new SimpleDateFormat("E, MMM d, yyyy").format(cal.getTime());

            tvNombre.setText(datoNombre);
            tvTelefono.setText(datoTelefono);
            tvEmail.setText(datoEmail);

            tvFecha.setText(format);

            //Buscamos el boton
            boton=(Button)findViewById(R.id.botonAtras);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Actividad2.this, Actividad1.class);
                    /*intAño = ((DatePicker) findViewById(R.id.campoFecha)).getYear();
                    intMes = ((DatePicker) findViewById(R.id.campoFecha)).getMonth();
                    intDia = ((DatePicker) findViewById(R.id.campoFecha)).getDayOfMonth();*/

                    intent.putExtra("nombre",tvNombre.getText().toString());
                    intent.putExtra("telefono",tvTelefono.getText().toString());
                    intent.putExtra("eMail",tvEmail.getText().toString()).toString();
                    intent.putExtra("descripcion",tvDesc.getText());

                    intent.putExtra(getString(R.string.pFecha_nacimientoYear), intAño);
                    intent.putExtra(getString(R.string.pFecha_nacimientoMonth), intMes);
                    intent.putExtra(getString(R.string.pFecha_nacimientoDay), intDia);

                    startActivity(intent);
                }
            });
        }
    }
}
