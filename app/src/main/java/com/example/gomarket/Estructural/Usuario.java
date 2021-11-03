package com.example.gomarket.Estructural;
import java.util.ArrayList;

public class Usuario {

    String Nombre, Clave;
    int id;

    public Usuario(String nombre, String clave, int id) {
        Nombre = nombre;
        Clave = clave;
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
