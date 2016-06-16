package com.example.josan.proyecto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";
    String user,pass,pass2;
    EditText campoUser,campoPass,campoPass2;
    public ProgressDialog cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


        findViewById(R.id.btn_registrarse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });}
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void registrar(){
        if(correcto()){
            cargando = ProgressDialog.show(this, "", "Registrandote...", true);
            campoUser = (EditText)findViewById(R.id.txt_correo);
            user = campoUser.getText().toString();
            campoPass = (EditText)findViewById(R.id.txt_pass);
            pass = campoPass.getText().toString();

            mAuth.createUserWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                cargando.dismiss();
                                Toast.makeText(Registro.this, "Fallo al registrarte", Toast.LENGTH_LONG).show();
                            }else {
                                cargando.dismiss();
                                Toast.makeText(Registro.this, "Registrado Correctamente", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Registro.this, Dif_partida.class);
                                startActivity(i);
                            }

                            // ...
                        }
                    });
        }
    }

    public boolean correcto(){

        campoUser = (EditText)findViewById(R.id.txt_correo);
        user = campoUser.getText().toString();
        campoPass = (EditText)findViewById(R.id.txt_pass);
        pass = campoPass.getText().toString();
        campoPass2 = (EditText)findViewById(R.id.txt_conpass);
        pass2 = campoPass2.getText().toString();


        if (user.length()==0){
            Toast.makeText(Registro.this, "Introduzca correo", Toast.LENGTH_SHORT).show();
            return false;
        }else if(pass.length()==0) {
            Toast.makeText(Registro.this, "Introduzca Contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }else if(pass.length()<6){
            Toast.makeText(Registro.this, "Contraseña demasiado corta (minimo 6 caracteres)", Toast.LENGTH_LONG).show();
            return false;
        }else if(!pass.equals(pass2)) {
            Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
