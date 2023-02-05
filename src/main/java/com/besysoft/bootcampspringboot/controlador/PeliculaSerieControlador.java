package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaSerieControlador {

    @GetMapping
    public List<PeliculaSerie> mostrarTodas() {
        return DatoDummyn.listaDePeliculas;
    }

    @GetMapping("/{tituloOGenero}")
    public ResponseEntity<?> buscarPorTitulo(@PathVariable String tituloOGenero) {
        return DatoDummyn.buscarPeliculaPorTituloOGenero(tituloOGenero);
    }

    @GetMapping("/fechas")
    public ResponseEntity<?> buscarPorFecha(@RequestParam String desde, @RequestParam String hasta){
        return DatoDummyn.buscarPeliculaPorFecha(desde, hasta);
    }

    @GetMapping("/calificacion")
    public ResponseEntity<?> buscarPorCalificacion(@RequestParam Integer desde, @RequestParam Integer hasta){
        return buscarPeliculasPorCalificacion(desde, hasta);
    }

    @PostMapping
    public ResponseEntity<?> agregarPelicula(@RequestBody PeliculaSerie pelicula){
        return agregarNuevaPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarPelicula (@PathVariable Long id, @RequestBody PeliculaSerie peliculaSerie){
        return actualizarPeliculaPorId(id, peliculaSerie);
    }




}