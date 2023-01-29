package com.besysoft.bootcampspringboot.dominio;

import java.util.List;

public class Genero {

    private Long id;
    private String nombre;
    private List<PeliculaSerie> peliculaSerie;

    public Genero() {
    }

    public Genero(Long id, String nombre, List<PeliculaSerie> peliculaSerie) {
        this.id = id;
        this.nombre = nombre;
        this.peliculaSerie = peliculaSerie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PeliculaSerie> getPeliculaSerie() {
        return peliculaSerie;
    }

    public void setPeliculaSerie(List<PeliculaSerie> peliculaSerie) {

        this.peliculaSerie = peliculaSerie;
    }
}
