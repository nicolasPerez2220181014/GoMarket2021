package com.example.gomarket.Estructural;
import java.util.ArrayList;

public class Gestor {

    String Nombre, Nit, Ubicacion, Descripcion, UrlImagen, Horario;
    int id;

    public Gestor (int id, String nombre, String nit, String ubicacion, String descripcion, String urlImagen, String horario){
        this.id = id;
        this.Nombre = nombre;
        this.Nit = nit;
        this.Ubicacion = ubicacion;
        this.Descripcion = descripcion;
        this.UrlImagen = urlImagen;
        this.Horario = horario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUrlImagen() {
        return UrlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        UrlImagen = urlImagen;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
