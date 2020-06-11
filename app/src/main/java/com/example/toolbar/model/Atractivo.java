package com.example.toolbar.model;

public class Atractivo {

    private int id;
    private String nombre;
    private String descripcion;
    private int imagen;
    private int video;
    private int idRuta;

    public Atractivo(int id, String nombre, String descripcion, int imagen, int video, int idRuta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.video = video;
        this.idRuta = idRuta;
    }

    public Atractivo() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.imagen = 0;
        this.video = 0;
        this.idRuta = 0;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }
}
