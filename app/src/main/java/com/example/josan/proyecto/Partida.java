package com.example.josan.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Partida  extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    ArrayAdapter adaptador;
    Bundle extras;
    int dif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.partida);

        //Instancia del ListView
        lista = (ListView)findViewById(R.id.lista);

        extras =  getIntent().getExtras();
        try{
        dif =  extras.getInt("dif");}
        catch (NullPointerException e){

        }
        if(dif ==5) {
            //Inicializar el adaptador con la fuente de datos
            adaptador = new TareaArrayAdapter(this, DataSource.TAREAS5);
        }else if (dif ==10){
            adaptador = new TareaArrayAdapter(this, DataSource.TAREAS10);
        }else{
            adaptador = new TareaArrayAdapter(this, DataSource.TAREAS15);}

        //Relacionando la lista con el adaptador
        lista.setAdapter(adaptador);

        //Estableciendo la escucha
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Tarea tareaActual = (Tarea)adaptador.getItem(position);
        //String msg = "Elegiste la tarea:\n"+tareaActual.getNombre()+"-"+tareaActual.getHora();
        //Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        Intent ip = new Intent(Partida.this, ubicacionP.class);
        ip.putExtra("ubi",tareaActual.getNombre());
        startActivity(ip);

    }
}
