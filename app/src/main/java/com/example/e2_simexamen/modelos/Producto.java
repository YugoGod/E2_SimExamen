package com.example.e2_simexamen.modelos;

import java.io.Serializable;

public class Producto implements Serializable {
    // ATRIBUTOS
    private String nombre;
    private float precio;
    private float total;
    private int cantidad;

    // CONSTRUCTORES
    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = cantidad * precio;
    }
    public Producto(){
    }

    // GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // MÉTODOS GENÉRICOS O PROPIOS
    public void actualizarTotal(){
        this.total = this.cantidad * this.precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", total=" + total +
                ", cantidad=" + cantidad +
                '}';
    }
}
