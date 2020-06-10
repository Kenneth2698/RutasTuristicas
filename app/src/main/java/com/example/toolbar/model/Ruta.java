package com.example.toolbar.model;

public class Ruta {

    private int id;
    private String nombre;
    private int precio;
    private int tipoTurista;
    private int tipoActividad;
    private String latitud;
    private String longitud;

    public Ruta(int id, String nombre, int precio, int tipoTurista, int tipoActividad, String latitud, String longitud) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoTurista = tipoTurista;
        this.tipoActividad = tipoActividad;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
