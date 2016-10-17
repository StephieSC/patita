package com.example.stephie.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.stephie.prueba.Historial;
import  com.example.stephie.prueba.HistorialAdapter;

public class HistorialActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private List<Historial> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        // Obtener el Recycler
        recycler= (RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        // Crear un nuevo adaptador
        adapter = new HistorialAdapter(items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
        Historial item1 = new Historial(2, "Angel Beats",1);
        Historial item2 = new Historial(3, "Death Note", 0);
        Historial item3 = new Historial(1, "Fate Stay Night",0);
        Historial item4 = new Historial(1, "Welcome to the NHK", 1);
        Historial item5 = new Historial(2, "Suzumiya Haruhi", 1);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);


// Usar un administrador para LinearLayout
        //lManager = new LinearLayoutManager(this);

        //notificar que los elementos cambiaron
        adapter.notifyDataSetChanged();
    }

}
