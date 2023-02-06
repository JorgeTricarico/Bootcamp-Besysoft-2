package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {

     List<Personaje> obtenerTodosLosPersonajes();
     ResponseEntity<?> buscarPorEdadONombre(String dato);
     ResponseEntity<?> buscarPersonajePorNombre(String nombre);
     ResponseEntity<?> buscarPersonajesPorEdad(Integer edad);
     ResponseEntity<?> buscarPersonajePorRangoDeEdad(Integer desde, Integer hasta);
     ResponseEntity agregarNuevoPersonaje(Personaje personaje);
     ResponseEntity actualizarPersonajePorId(Long id, Personaje personajeAct);

}
