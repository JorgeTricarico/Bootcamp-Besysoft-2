package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaSerieControlador {

    @GetMapping
    public List<PeliculaSerie> mostrarTodas() {

        return DatoDummyn.listaDePeliculas;
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<?> buscarPorTitulo(@PathVariable String titulo) {

        return DatoDummyn.buscarPorTitulo(titulo);
    }

    @GetMapping("/genero/{nombreGenero}")
    public ResponseEntity<?> buscarPorGenero(@PathVariable String nombreGenero) {

        return DatoDummyn.buscarPorGenero(nombreGenero);
    }


}