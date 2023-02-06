package com.besysoft.bootcampspringboot.respositories.implementations;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.respositories.interfaces.IPeliculaSerieRepository;

import java.util.Optional;

public class PeliculasRepositoryImp implements IPeliculaSerieRepository {


    @Override
    public Optional<PeliculaSerie> buscarComoRepoTituloPelicula(String titulo) {
        return listaDePeliculas.stream()
                .filter(pelis -> pelis.getTitulo().equalsIgnoreCase(titulo))
                .findAny();
    }

    @Override
    public Optional<PeliculaSerie> buscarComoRepoPeliculaPorID(Long id) {
        return listaDePeliculas.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }
    
}
