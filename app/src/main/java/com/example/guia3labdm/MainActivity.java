package com.example.guia3labdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//declarando variables
    Button agregarnombre;
    Button listanombres;
    Button misDatos;
    //contador para controlar los nombres
    Integer contadornombres = 0 ;
    //arreglo para los nombres (lista String)
    ArrayList<String> nombres = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarnombre = findViewById(R.id.btnnombre);
        listanombres = findViewById(R.id.btnverlista);
        misDatos = findViewById(R.id.btnmisdatos);

        agregarnombre.setOnClickListener(this);
        listanombres.setOnClickListener(this);
        misDatos.setOnClickListener(this);

        //validamos si tenemos algo que recibir del registro de nombres
        //si recibimos
        if(getIntent().getExtras()!= null)
        {
                // recibimos el numero de registros
            contadornombres = getIntent().getExtras().getInt("contador");
            // recibimos el arrgeglo actual de nombres
            nombres = (ArrayList<String>) getIntent().getSerializableExtra("nombres");}
        else
        {
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            // agregar nombre
            case R.id.btnnombre:
                Intent nomb = new Intent(MainActivity.this,AgregarNombre.class);
                nomb.putExtra("cont",contadornombres);
                nomb.putExtra("nombresarray",nombres);
                startActivity(nomb);
                break;
                // ver mis datos
            case R.id.btnmisdatos:
                Intent kiko = new Intent(MainActivity.this,MisDatos.class);
                startActivity(kiko);
                break;

                // ver lista de registros
            case R.id.btnverlista:

                // si no hay registros, la lista esta cerrada para el usuario
if(contadornombres ==0 )
{
    Toast.makeText(getApplicationContext(),"no hay datos en la lista",Toast.LENGTH_LONG).show();
}
else
{
    Intent opuesta = new Intent(MainActivity.this,VerLista.class);
    //mandamos el arreglo actual del nombre
            opuesta.putExtra("nombres",nombres);
    startActivity(opuesta);
}
                break;
        }
    }
}
