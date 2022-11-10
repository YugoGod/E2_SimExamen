package com.example.e2_simexamen.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.e2_simexamen.R;
import com.example.e2_simexamen.databinding.ActivityCrearProductoBinding;
import com.example.e2_simexamen.databinding.ActivityMainBinding;

public class CrearProductoActivity extends AppCompatActivity {

    private ActivityCrearProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCrearProductoBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnCrearAddProducto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nombre = binding.txtNombreProductoAddProducto.getText().toString();
                String cantidad = binding.txtCantidadProductoAddProducto.getText().toString();
                String precio = binding.txtPrecioProductoAddProducto.getText().toString();

                if (!nombre.isEmpty() && !cantidad.isEmpty() && !precio.isEmpty()){
                    Producto producto = new Producto(nombre, Float.parseFloat(precio), Integer.parseInt(cantidad));
                    Bundle b = new Bundle();
                    b.putSerializable("PROD", producto);
                    Intent intent = new Intent();
                    intent.putExtras(b);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {
                    Toast.makeText(CrearProductoActivity.this, "Faltan datos.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}