package com.besysoft.bootcampspringboot.respositories.interfaces;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.apache.catalina.users.GenericRole;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface IGeneroRepository {


    void agregarNuevoGenero(Genero genero);
    List<Genero> obtenerTodosLosGeneros();
    static List<Genero> crearDatosGenero() {

        List<String> listaPeliculaSerieDrama = new ArrayList<>(Arrays.asList(("El Temblor 1"), ("El Temblor 2"), ("La Esclava")));
        List<String> listaPeliculaSerieAventura = new ArrayList<>(Arrays.asList(("Harry Potter 1"), ("Harry Potter 2"), ("Harry Potter 3"), ("Harry Potter 4"),("Harry Potter 5")));
        List<String> listaPeliculaSerieAccion = new ArrayList<>(Arrays.asList(("Rapido y Furioso 1"), ("Rapido y Furioso 2"), ("Rapido y Furioso 3"), ("Rapido y Furioso 4"), ("Rapido y Furioso 30")));
        List<String> listaPeliculaSerieTerror = new ArrayList<>(Arrays.asList(("La Huerfana 1"), ("La Huerfana 2"), ("La Huerfana 3"), ("La Huerfana 4"), ("Juego del Miedo 1"), ("Juego del Miedo 2"), ("Juego del Miedo 3"), ("Juego del Miedo 4")));


        List<Genero> listaDeGeneros = new ArrayList<>(Arrays.asList(new Genero(1L, "Drama", listaPeliculaSerieDrama), new Genero(2L, "Aventura", listaPeliculaSerieAventura), new Genero(3L, "Accion", listaPeliculaSerieAccion), new Genero(4L, "Terror", listaPeliculaSerieTerror)));

        return listaDeGeneros;
    } //GeneroRepository
    Optional<Genero> buscarGeneroPorId(Long id);

}
