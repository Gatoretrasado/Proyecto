package com.example.josan.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class Login extends AppCompatActivity {
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText campoUser = (EditText)findViewById(R.id.txt_correo);
         user = campoUser.getText().toString();
        EditText campoPass = (EditText)findViewById(R.id.txt_pass);
         pass = campoPass.getText().toString();



        findViewById(R.id.lbl_olvpass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.startActivity(new Intent(Login.this, Recordar.class));
            }
        });


        findViewById(R.id.btn_registrarse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    private void entrar() {
        if (seguridad()){

        }
    }
    private boolean seguridad(){

        if (user.length()==0){
            return false;
        }

        return true;
    }

}
