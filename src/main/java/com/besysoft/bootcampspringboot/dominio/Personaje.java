package com.besysoft.bootcampspringboot.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personaje {

    private Long id;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;

    @JsonIgnore
    private List<PeliculaSerie> peliculaSerieAsociada;

    //private List<String> peliculaSerieAsociada;

    public Personaje() {
    }

    public Personaje(Long id, String nombre, Integer edad, Float peso, String historia, List<PeliculaSerie> peliculaSerieAsociada) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculaSerieAsociada = peliculaSerieAsociada;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<PeliculaSerie> getPeliculaSerieAsociada() {
        return peliculaSerieAsociada;
    }

    public void setPeliculaSerieAsociada(List<PeliculaSerie> peliculaSerieAsociada) {
        this.peliculaSerieAsociada = peliculaSerieAsociada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(id, personaje.id) && Objects.equals(nombre, personaje.nombre) && Objects.equals(edad, personaje.edad) && Objects.equals(peso, personaje.peso) && Objects.equals(historia, personaje.historia) && Objects.equals(peliculaSerieAsociada, personaje.peliculaSerieAsociada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, edad, peso, historia, peliculaSerieAsociada);
    }
}


