package com.example.e2_simexamen.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e2_simexamen.R;
import com.example.e2_simexamen.modelos.Producto;

import java.text.NumberFormat;
import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ProductoVH> {

    private List<Producto> objects;
    private int resources;
    private Context context;
    private NumberFormat nf;

    public AdapterProducto(List<Producto> objects, int resources, Context context) {
        this.objects = objects;
        this.resources = resources;
        this.context = context;
        this.nf = NumberFormat.getCurrencyInstance();
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoCardView = LayoutInflater.from(context).inflate(resources, null);
        productoCardView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ProductoVH(productoCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {
        Producto p = objects.get(position);
        holder.lblNombre.setText(p.getNombre());
        holder.lblCantidad.setText(String.valueOf(p.getNombre()));

        holder.lblPrecio.setText(nf.format(p.getPrecio()));
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDelete(p, holder.getAdapterPosition());
            }
        });
    }

    private AlertDialog confirmDelete(Producto p, int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Seguro?");
        builder.setCancelable(false);

        builder.setNegativeButton("Cancelar", null);
        builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                objects.remove(p);
                notifyItemRemoved(position);
            }
        });

        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {

        TextView lblNombre;
        TextView lblCantidad;
        TextView lblPrecio;
        ImageButton btnEliminar;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombreProductoCard);
            lblCantidad = itemView.findViewById(R.id.lblCantidadProductoCard);
            lblPrecio = itemView.findViewById(R.id.lblPrecioProductoCard);
        }
    }
}
