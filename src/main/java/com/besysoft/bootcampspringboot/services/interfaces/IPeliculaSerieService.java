package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPeliculaSerieService {

    List<PeliculaSerie> obtenerTodasLasPeliculas();

    ResponseEntity<?> buscarPeliculaPorTituloOGenero(String tituloOGenero);

    ResponseEntity<?> buscarPeliculaPorFecha(String desde, String hasta);
    ResponseEntity<?> buscarPeliculasPorCalificacion(Integer desde, Integer hasta);
    ResponseEntity agregarNuevaPelicula(PeliculaSerie pelicula);
    ResponseEntity actualizarPeliculaPorId(Long id, PeliculaSerie peliculaSerie);

}
