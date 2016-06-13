package com.example.josan.proyecto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;


public class Login extends AppCompatActivity {
    String user,pass;
    public ProgressDialog cargando;
    private FirebaseAuth Autentificacion;
    private SharedPreferences preferencias;
    EditText campoUser,campoPass;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

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
        // ...
    }

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

    private void entrar() {
        if (seguridad()){
            cargando = ProgressDialog.show(this, "", "Estamos buscandote...", true);

            campoUser = (EditText)findViewById(R.id.txt_correo);
            user = campoUser.getText().toString();
            campoPass = (EditText)findViewById(R.id.txt_pass);
            pass = campoPass.getText().toString();

            mAuth.signInWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                cargando.dismiss();
                                Log.w(TAG, "signInWithEmail", task.getException());
                                Toast.makeText(Login.this, "Usuario no encontrado.", Toast.LENGTH_LONG).show();
                            }
                            else{
                                cargando.dismiss();
                                Intent i = new Intent(Login.this, Dif_partida.class);
                                startActivity(i);
                            }

                            // ...
                        }
                    });


        }
    }
    private boolean seguridad(){

        campoUser = (EditText)findViewById(R.id.txt_correo);
        user = campoUser.getText().toString();
        campoPass = (EditText)findViewById(R.id.txt_pass);
        pass = campoPass.getText().toString();


        if (user.length()==0){
            Toast.makeText(Login.this, "Introduzca usuario", Toast.LENGTH_SHORT).show();
            return false;
        }else if(pass.length()==0){
            Toast.makeText(Login.this, "Introduzca Contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
