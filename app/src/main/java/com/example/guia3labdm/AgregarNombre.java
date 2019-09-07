package com.example.guia3labdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class AgregarNombre extends AppCompatActivity implements View.OnClickListener {

    EditText nombre;
    Button agregarnombre;
    //contador de nombres;
    Integer contadornombres;
    Handler h = new Handler();
    ProgressBar barra;
    ArrayList<String> nombres = new ArrayList<String>();
    int i =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);
        nombre = findViewById(R.id.txtnombre);
        agregarnombre = findViewById(R.id.btnagregarnombre);

        agregarnombre.setOnClickListener(this);
        contadornombres = getIntent().getExtras().getInt("cont");
        nombres = (ArrayList<String>) getIntent().getSerializableExtra("nombresarray");
        barra= findViewById(R.id.barra);
      //  Toast.makeText(this,"el contador de nombres esta en: "+contadornombres, Toast.LENGTH_LONG).show();
    }

   private void agregarNombre()
    {
        String nomb = nombre.getText().toString();
        Intent pasar = new Intent(AgregarNombre.this,MainActivity.class);
        contadornombres ++;
        // agregamos el nombre al array
        nombres.add(nomb);
        pasar.putExtra("nomb",nomb);
        // arreglo de nombres
        pasar.putExtra("nombres",nombres);
        pasar.putExtra("contador",contadornombres);

        // iniciamos la activity
        startActivity(pasar);
    }

    @Override
    public void onClick(View view) {

        //verificamos si hay nombre en el txtbox
            String nomb = nombre.getText().toString();
        if(nomb.isEmpty())
        {
            Toast.makeText(this," Porfavor Ingrese nombre",Toast.LENGTH_SHORT).show();
        }
        else
        {

            Thread carga = new Thread(new Runnable() {
                @Override
                public void run() {


                    while (i <= 100) {
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                barra.setProgress(i);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(i==100)
                        {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   // mensaje();
                                    //pasamos los correspondientes parametros a la activity principal
                                    //  Toast.makeText(getApplicationContext(), "el nombre ingresado es: "+ nomb, Toast.LENGTH_LONG).show();
                               agregarNombre();

                                }
                            });


                        }


                        i = i+20;
                    }


                }
            });  carga.start();



        }
    }
}
