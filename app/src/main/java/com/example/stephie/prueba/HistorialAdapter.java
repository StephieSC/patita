package com.example.stephie.prueba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Stephie on 16-10-2016.
 */
public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>{

        private List<Historial> items;

    public  HistorialAdapter(List<Historial> items) {
        this.items = items;
    }

        public static class HistorialViewHolder extends RecyclerView.ViewHolder {
            // Campos respectivos de un item
            public TextView nivel;
            public TextView fecha;
            public TextView logrado;

            public HistorialViewHolder(View v) {
                super(v);
                nivel = (TextView) v.findViewById(R.id.historialnivel);
                fecha = (TextView) v.findViewById(R.id.historialfecha);
                logrado = (TextView) v.findViewById(R.id.historiallogrado);
            }
        }



        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public HistorialViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.historial, viewGroup, false);
            return new HistorialViewHolder(v);
        }

        @Override
        public void onBindViewHolder(HistorialViewHolder viewHolder, int i) {
            viewHolder.nivel.setText(items.get(i).getNivel());
            viewHolder.fecha.setText(items.get(i).getfecha());
            viewHolder.logrado.setText(String.valueOf(items.get(i).getLogrado()));
        }

}
