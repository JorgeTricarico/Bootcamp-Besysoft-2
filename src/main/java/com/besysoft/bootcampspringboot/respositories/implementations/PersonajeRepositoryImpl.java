package com.besysoft.bootcampspringboot.respositories.implementations;

import com.besysoft.bootcampspringboot.dominio.Personaje;

import com.besysoft.bootcampspringboot.respositories.interfaces.IPersonajeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    List<Personaje> listaDePersonajes = IPersonajeRepository.crearPersonajes();

    @Override
    public List<Personaje> obtenerTodosLosPersonajes() {
        return listaDePersonajes;
    }

    @Override
    public void agregarNuevoPersonaje(Personaje personaje) {
        listaDePersonajes.add(personaje);
    }

    @Override
    public Optional<Personaje> buscarPersonajePorNombre(String nombre) {
        return listaDePersonajes.stream()
                .filter(pelis -> pelis.getNombre().equalsIgnoreCase(nombre))
                .distinct()
                .findAny();
    }

    @Override
    public Optional<Personaje> buscarPersonajesPorEdad(Integer edad) {
        return listaDePersonajes.stream()
                .filter(personaje -> personaje.getEdad() == edad)
                .findAny();
    }

    @Override
    public List<Personaje> buscarPersonajesPorRangoDeEdad(Integer desde, Integer hasta) {
        return listaDePersonajes.stream()
                .filter(p -> p.getEdad() >= desde && p.getEdad() <= hasta)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Personaje> buscarPersonajePorId(Long id) {
        return listaDePersonajes.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }
}
