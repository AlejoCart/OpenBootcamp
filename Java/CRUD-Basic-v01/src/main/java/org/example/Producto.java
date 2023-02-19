package org.example;

public class Producto {
    private int precio;
    private String nombre;
    private String descipcion;
    private String img;

    public Producto(int precio, String nombre, String descipcion, String img) {
        this.precio = precio;
        this.nombre = nombre;
        this.descipcion = descipcion;
        this.img = img;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                ", descipcion='" + descipcion + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
