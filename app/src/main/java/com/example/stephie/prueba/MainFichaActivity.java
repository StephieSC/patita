package com.example.stephie.prueba;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainFichaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ficha);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button botontexto = (Button) findViewById(R.id.botontexto);
        Button botoncan = (Button) findViewById(R.id.botoncancelar);


        botontexto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText entrega= (EditText) findViewById(R.id.texto);
                String textofinal;
                textofinal = entrega.getText().toString();
                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                textofinal, Toast.LENGTH_SHORT);
                toast2.show();
            }
        });
        botoncan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "CANCELADO", Toast.LENGTH_SHORT);
                toast1.show();

            }

        });


    }}

