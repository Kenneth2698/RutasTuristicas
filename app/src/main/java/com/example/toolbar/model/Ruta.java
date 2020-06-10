package com.example.toolbar.model;

public class Ruta {

    private int id;
    private String nombre;
    private int precio;
    private int tipoTurista;
    private int tipoActividad;

    public Ruta(int id, String nombre, int precio, int tipoTurista, int tipoActividad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoTurista = tipoTurista;
        this.tipoActividad = tipoActividad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipoTurista() {
        return tipoTurista;
    }

    public void setTipoTurista(int tipoTurista) {
        this.tipoTurista = tipoTurista;
    }

    public int getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(int tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
