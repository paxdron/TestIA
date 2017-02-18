package com.paxdron.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Antonio on 18/02/2017.
 */

public class AdapterCiudades extends RecyclerView.Adapter<AdapterCiudades.ViewHolder> {

    private List<Ciudad> Ciudades;
    private Context context;

    public AdapterCiudades(List<Ciudad> ciudades, Context context) {
        Ciudades = ciudades;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ciudad, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ciudad ciudad= Ciudades.get(position);
        holder.tvCiudad.setText(ciudad.getNombre());
        holder.tvEstado.setText(ciudad.getEstado());
        holder.tvLatitud.setText(String.format(context.getString(R.string.tvLatitud),new DecimalFormat("#.##").format(ciudad.getLatitud())));
        holder.tvLongitud.setText(String.format(context.getString(R.string.tvLongitud),new DecimalFormat("#.##").format(ciudad.getLongitud())));
        holder.tvIDEstado.setText(String.format(context.getString(R.string.tvIdEstado),ciudad.getIdEstado()));
    }

    @Override
    public int getItemCount() {
        return Ciudades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCiudad;
        public TextView tvEstado;
        public TextView tvIDEstado;
        public TextView tvLatitud;
        public TextView tvLongitud;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCiudad = (TextView) itemView.findViewById(R.id.tvCiudad);
            tvEstado = (TextView) itemView.findViewById(R.id.tvEstado);
            tvIDEstado = (TextView) itemView.findViewById(R.id.tvIdEstado);
            tvLatitud = (TextView) itemView.findViewById(R.id.tvLatitud);
            tvLongitud = (TextView) itemView.findViewById(R.id.tvLongitud);

        }
    }

}
