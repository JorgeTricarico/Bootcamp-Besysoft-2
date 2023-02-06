package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.services.interfaces.IPeliculaSerieService;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaSerieControlador {

    @Autowired
    IPeliculaSerieService peliculaSerieService;

    @GetMapping
    public List<PeliculaSerie> mostrarTodas() {
        return peliculaSerieService.obtenerTodasLasPeliculas();
    }

    @GetMapping("/{tituloOGenero}")
    public ResponseEntity<?> buscarPorTitulo(@PathVariable String tituloOGenero) {
        return peliculaSerieService.buscarPeliculaPorTituloOGenero(tituloOGenero);
    }

    @GetMapping("/fechas")
    public ResponseEntity<?> buscarPorFecha(@RequestParam String desde, @RequestParam String hasta){
        return peliculaSerieService.buscarPeliculaPorFecha(desde, hasta);
    }

    @GetMapping("/calificacion")
    public ResponseEntity<?> buscarPorCalificacion(@RequestParam Integer desde, @RequestParam Integer hasta){
        return peliculaSerieService.buscarPeliculasPorCalificacion(desde, hasta);
    }

    @PostMapping
    public ResponseEntity<?> agregarPelicula(@RequestBody PeliculaSerie pelicula){
        return peliculaSerieService.agregarNuevaPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarPelicula (@PathVariable Long id, @RequestBody PeliculaSerie peliculaSerie){
        return peliculaSerieService.actualizarPeliculaPorId(id, peliculaSerie);
    }




}