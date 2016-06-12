package com.example.josan.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);



        findViewById(R.id.btn_registrarse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registro.this.startActivity(new Intent(Registro.this, Dif_partida.class));
            }
        });}

}
