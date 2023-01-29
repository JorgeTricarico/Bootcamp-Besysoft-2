package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    @GetMapping
    public List<Personaje> mostrarTodos() {

        return DatoDummyn.listaDePersonajes;
    }

    @GetMapping("/{dato}")
    public List<Personaje> validarIngresoEndPoint(@PathVariable String dato) {
        if (dato.matches("^[0-9]+$")) {
            Integer datoAInteger = Integer.parseInt(dato);
            return buscarPersonajesPorEdad(datoAInteger);
        } else {
            return buscarPersonajePorNombre(dato);
        }
    }

    //@GetMapping("/{nombre}")
    public List<Personaje> buscarPersonajePorNombre(@PathVariable String nombre) {
        if (nombre == null) {
            throw new NullPointerException("Nombre no puede ser nulo.");
        }

        // Valida letras y numeros para peliculas con numeros.
        Boolean sonSoloLetras = nombre.matches("^[a-zA-Z ]+$");

        if (!sonSoloLetras) {
            throw new IllegalArgumentException("Ingrese un nombre valido");
        }

        // Busca algun nombre que contenga la el string {nombre}
        List<Personaje> personajes = DatoDummyn.listaDePersonajes.stream()
                .filter(pelis -> pelis.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());


        if (personajes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return personajes;
    }

    //@GetMapping("/edad/{edad}")
    public List<Personaje> buscarPersonajesPorEdad(@PathVariable Integer edad) {
        if (edad == null) {
            throw new NullPointerException("Edad no puede ser nulo.");
        }

        // Valida  numeros para edad.
        Boolean sonSoloNumeros = edad.toString().matches("^[0-9]+$");

        if (!sonSoloNumeros) {
            throw new IllegalArgumentException("Ingrese un numero valido");
        }

        // Busca algun nombre que contenga la el string {nombre}
        List<Personaje> listaPersonajes = DatoDummyn.listaDePersonajes.stream()
                .filter(personaje -> personaje.getEdad() == edad)
                .collect(Collectors.toList());


        if (listaPersonajes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return listaPersonajes;
    }


}
