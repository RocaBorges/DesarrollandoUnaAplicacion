package com.example.robertoborges.desarrollandounaaplicacion;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class FormularioContacto extends AppCompatActivity {

    EditText NombreUsuario, Fecha_Nacimiento, Telefono, E_mail, Descricion_Contacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        NombreUsuario = (EditText) findViewById(R.id.NombreUsuario);
        Fecha_Nacimiento = (EditText) findViewById(R.id.FechaNacimiento);
        Telefono = (EditText) findViewById(R.id.Telefono);
        E_mail = (EditText) findViewById(R.id.E_mail);
        Descricion_Contacto = (EditText) findViewById(R.id.Descricion_Contacto);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            String Nombre_Usuario = bundle.getString("Nombre");
            String Fecha = bundle.getString("Fecha");
            String Telen = bundle.getString("Telen");
            String E_mails = bundle.getString("E_mails");
            String Descricion = bundle.getString("Descricion");


            NombreUsuario.setText(Nombre_Usuario);
            Fecha_Nacimiento.setText(Fecha);
            Telefono.setText(Telen);
            E_mail.setText(E_mails);
            Descricion_Contacto.setText(Descricion);

        }

    }

    public void siguiente(View view) {

        Intent intent = new Intent(FormularioContacto.this, ConfirmacionDeDatos.class);

        String Nombre_Usuario = NombreUsuario.getText().toString();
        String Telf = Telefono.getText().toString();
        String e_mail = E_mail.getText().toString();
        String descricion_Contacto = Descricion_Contacto.getText().toString();
        String fecha_Nacimiento = Fecha_Nacimiento.getText().toString();

        intent.putExtra("NombreUsuario", Nombre_Usuario);
        intent.putExtra("Telefono", Telf);
        intent.putExtra("E_mail", e_mail);
        intent.putExtra("Descricion_Contacto", descricion_Contacto);
        intent.putExtra("Fecha_Nacimiento", fecha_Nacimiento);

        startActivity(intent);
       // finish();
    }
    //DATE PICKER
    public void fecha(View view) {

        Calendar c = Calendar.getInstance();

        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int año = c.get(Calendar.YEAR);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Fecha_Nacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }
                , dia, mes, año);

        datePickerDialog.getDatePicker().getMaxDate();

        datePickerDialog.show();


    }

}

