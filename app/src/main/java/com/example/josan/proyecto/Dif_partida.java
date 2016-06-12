package com.example.josan.proyecto;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Toast;


public class Dif_partida extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dif_partida);



        findViewById(R.id.btn_5u).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(Dif_partida.this, "5 localizaciones", Toast.LENGTH_SHORT).show();
            }
        });}

}
