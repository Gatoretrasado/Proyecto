package com.example.josan.proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Recordar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordar);


        findViewById(R.id.btn_enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Enviar_Correo();
            }
        });
    }



    public void Enviar_Correo() {
    //añadir metodo para validar el correo
        EditText campoCorreo = (EditText)findViewById(R.id.txt_correo);
        assert campoCorreo != null;
        String correo = campoCorreo.getText().toString();

        if (!Objects.equals(correo, "")) {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Recordar.this, "Correo Enviado", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    if (!task.isSuccessful()) {
                        Log.w("ERROR", "ERROR RESET", task.getException());
                        Toast.makeText(Recordar.this, "No encontamos tu correo", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}