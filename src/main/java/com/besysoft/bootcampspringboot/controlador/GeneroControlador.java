package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.actualizarGeneroPorId;
import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.actualizarPersonajePorId;


@RestController
@RequestMapping("/generos")
public class GeneroControlador {

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosGeneros(){

        return DatoDummyn.obtenerTodosLosGeneros();
    }
    @PostMapping
    public ResponseEntity<?> agregarNuevoGenero(@RequestBody Genero genero ) {
        return DatoDummyn.agregarNuevoGenero(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarGenero (@PathVariable Long id, @RequestBody Genero genero){
        return actualizarGeneroPorId(id, genero);
    }

}
