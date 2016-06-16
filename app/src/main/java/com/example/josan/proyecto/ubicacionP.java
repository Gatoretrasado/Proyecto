package com.example.josan.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ubicacionP extends AppCompatActivity {

    String uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubicacion);

        uni = getIntent().getExtras().getString("ubi");

        TextView tipo = (TextView)findViewById(R.id.lbl_tipo2);
        tipo.setText(uni);

        findViewById(R.id.btn_comp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ubicacionP.this, "NOOO!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
