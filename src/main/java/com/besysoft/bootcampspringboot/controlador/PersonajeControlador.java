package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    @GetMapping
    public List<Personaje> mostrarTodos() {
        return DatoDummyn.listaDePersonajes;
    }
    //No se si sobrecargar este controlador es buena practica, tal vez era mejor usar @ResquestParam
    @GetMapping("/{dato}")
    public ResponseEntity<?> buscarPorEdadONombre(@PathVariable String dato) {
        return DatoDummyn.buscarPorEdadONombre(dato);
    }
    @GetMapping("/edad")
    ResponseEntity<?> buscarPorRangoDeEdad (@RequestParam Integer desde, @RequestParam Integer hasta){
        return buscarPersonajePorRangoDeEdad(desde, hasta);
    }
    @PostMapping
    public ResponseEntity<?> agregarPersonaje(@RequestBody Personaje personaje){
        return agregarNuevoPersonaje(personaje);
    }
    @PutMapping("/{id}")
    public ResponseEntity actualizarPersonaje (@PathVariable Long id, @RequestBody Personaje personaje){
        return actualizarPersonajePorId(id, personaje);
    }







}
