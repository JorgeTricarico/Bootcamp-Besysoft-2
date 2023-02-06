package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.services.interfaces.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import static com.besysoft.bootcampspringboot.utilidades.DatoDummyn.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping
    public List<Personaje> mostrarTodos() {
        return personajeService.obtenerTodosLosPersonajes();
    }
    //No se si sobrecargar este controlador es buena practica, tal vez era mejor usar @ResquestParam
    @GetMapping("/{dato}")
    public ResponseEntity<?> buscarPorEdadONombre(@PathVariable String dato) {
        return personajeService.buscarPorEdadONombre(dato);
    }
    @GetMapping("/edad")
    ResponseEntity<?> buscarPorRangoDeEdad (@RequestParam Integer desde, @RequestParam Integer hasta){
        return personajeService.buscarPersonajePorRangoDeEdad(desde, hasta);
    }
    @PostMapping
    public ResponseEntity<?> agregarPersonaje(@RequestBody Personaje personaje){
        return personajeService.agregarNuevoPersonaje(personaje);
    }
    @PutMapping("/{id}")
    public ResponseEntity actualizarPersonajePorId (@PathVariable Long id, @RequestBody Personaje personaje){
        return personajeService.actualizarPersonajePorId(id, personaje);
    }







}
