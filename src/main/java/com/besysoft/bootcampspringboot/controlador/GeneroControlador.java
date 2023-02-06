package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.respositories.interfaces.IGeneroRepository;
import com.besysoft.bootcampspringboot.services.interfaces.IGeneroService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/generos")
public class GeneroControlador {

    @Autowired
    IGeneroService generoService;

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosGeneros(){
        return generoService.obtenerTodosLosGeneros();
    }
    @PostMapping
    public ResponseEntity<?> agregarNuevoGenero(@RequestBody Genero genero ) {
        return generoService.agregarNuevoGenero(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarGeneroPorId (@PathVariable Long id, @RequestBody Genero genero){
        return generoService.actualizarGeneroPorId(id, genero);
    }

}
