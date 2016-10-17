package com.example.stephie.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.stephie.prueba.Historial;
import  com.example.stephie.prueba.HistorialAdapter;

public class HistorialActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        List<Historial> items = new ArrayList();
        items.add(new Historial(2, "Angel Beats",1));
        items.add(new Historial(3, "Death Note", 0));
        items.add(new Historial(1, "Fate Stay Night",0));
        items.add(new Historial(1, "Welcome to the NHK", 1));
        items.add(new Historial(2, "Suzumiya Haruhi", 1));
        // Obtener el Recycler
        recycler= (RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new HistorialAdapter(items);
        recycler.setAdapter(adapter);
    }

}
