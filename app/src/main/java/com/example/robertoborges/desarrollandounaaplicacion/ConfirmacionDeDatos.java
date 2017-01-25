package com.example.robertoborges.desarrollandounaaplicacion;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


public class ConfirmacionDeDatos extends AppCompatActivity {

    TextView TextView1, TextView2, TextView3, TextView4, TextView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_datos);

        TextView1 = (TextView) findViewById(R.id.Nombre_Usuario);
        TextView2 = (TextView) findViewById(R.id.Fecha_Nacimiento);
        TextView3 = (TextView) findViewById(R.id.Telefono);
        TextView4 = (TextView) findViewById(R.id.E_mail);
        TextView5 = (TextView) findViewById(R.id.Descricion_Contacto);

        Bundle bundle = getIntent().getExtras();
        String Nombre_Usuario = bundle.getString("NombreUsuario");
        String Fecha_Nacimiento = bundle.getString("Fecha_Nacimiento");
        String Telefono = bundle.getString("Telefono");
        String E_mail = bundle.getString("E_mail");
        String Descricion_Contacto = bundle.getString("Descricion_Contacto");

        TextView1.setText(Nombre_Usuario);
        TextView2.setText(Fecha_Nacimiento);
        TextView3.setText(Telefono);
        TextView4.setText(E_mail);
        TextView5.setText(Descricion_Contacto);

        ActionBar BtnBack = getSupportActionBar();
        BtnBack.setDisplayHomeAsUpEnabled(true);

    }

    public void Editar_Datos(View view) {

        Intent intent = new Intent(this, FormularioContacto.class);

        Bundle bundle = getIntent().getExtras();
        String Nombre_Usuario = bundle.getString("NombreUsuario");
        String Fecha_Nacimiento = bundle.getString("Fecha_Nacimiento");
        String Telefono = bundle.getString("Telefono");
        String E_mail = bundle.getString("E_mail");
        String Descricion_Contacto = bundle.getString("Descricion_Contacto");

        intent.putExtra("Nombre", Nombre_Usuario);
        intent.putExtra("Fecha", Fecha_Nacimiento);
        intent.putExtra("Telen", Telefono);
        intent.putExtra("E_mails", E_mail);
        intent.putExtra("Descricion", Descricion_Contacto);

        startActivity(intent);
        finish();

    }
    //DESTRUYE LA ACTIVITY ANTERIOR Y CREA LA ACTUAL
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(ConfirmacionDeDatos.this, FormularioContacto.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);

    }



}

