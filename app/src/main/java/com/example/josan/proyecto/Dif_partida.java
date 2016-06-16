package com.example.josan.proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Toast;


public class Dif_partida extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dif_partida);



        findViewById(R.id.btn_5u).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 i = new Intent(Dif_partida.this, Partida.class);
                i.putExtra("dif", 5);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_10u).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(Dif_partida.this,  Partida.class);
                i.putExtra("dif", 10);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_15u).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(Dif_partida.this,  Partida.class);
                i.putExtra("dif", 15);
                startActivity(i);
            }
        });
    }
}
