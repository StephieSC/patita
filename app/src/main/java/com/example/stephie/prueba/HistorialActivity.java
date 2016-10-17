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
        // Obtener el Recycler
        setContentView(R.layout.activity_historial);
        recycler= (RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(lManager);
        List<Historial> items = new ArrayList<>();
        items.add(new Historial(2, "13-10-2016",1));
        items.add(new Historial(3, "14-10-2016", 0));
        items.add(new Historial(1, "15-10-2016",0));
        items.add(new Historial(1, "16-10-2016", 1));
        items.add(new Historial(2, "17-10-2016", 1));
// Crear un nuevo adaptador
        adapter = new HistorialAdapter(items);
        recycler.setAdapter(adapter);
    }

}
