package com.example.guia3labdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VerLista extends AppCompatActivity  {

    ArrayList<String> nombres = new ArrayList<String>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);
lista = findViewById(R.id.listnomb);
        if(getIntent().getExtras()!= null)
        {
            nombres = (ArrayList<String>) getIntent().getSerializableExtra("nombres");
        }
        else
        {

        }
        // adaptamos la lista al array
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombres);
        lista.setAdapter(adaptador);
    }


}
