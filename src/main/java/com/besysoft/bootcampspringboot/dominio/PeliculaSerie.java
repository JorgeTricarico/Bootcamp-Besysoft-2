package com.besysoft.bootcampspringboot.dominio;

import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PeliculaSerie {
    private List<Personaje> listaPersonajes = DatoDummyn.listaDePersonajes;

    private Long id;

    private String titulo;
    private LocalDate fechaDeCreacion;
    private Integer calificacion;
    private List<Personaje> personajesAsociados;

    public PeliculaSerie() {
    }

    public PeliculaSerie(Long id, String titulo, String fechaDeCreacion, Integer calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDeCreacion = LocalDate.parse(fechaDeCreacion);
        this.calificacion = calificacion;

        List<Personaje> personajes = new ArrayList<>();

        /*listaPersonajes.forEach(personaje -> {
            personaje.getPeliculaSerieAsociada().forEach(pelicula -> {
                if (pelicula.getTitulo().equalsIgnoreCase(this.titulo)) {
                    personajes.add(personaje);
                }
            });
        });*/

        this.personajesAsociados = personajes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(List<Personaje> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PeliculaSerie{" +
                "titulo='" + titulo + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", calificacion=" + calificacion +
                ", personajesAsociados=" + personajesAsociados +
                '}';
    }
}
