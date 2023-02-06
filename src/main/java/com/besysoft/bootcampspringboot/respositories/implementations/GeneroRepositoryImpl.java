package com.besysoft.bootcampspringboot.respositories.implementations;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.respositories.interfaces.IGeneroRepository;

import java.util.List;
import java.util.Optional;

public class GeneroRepositoryImp implements IGeneroRepository {


    @Override
    public Optional<Genero> buscarComoRepoGeneroPorID(Long id) {
        return listaDeGeneros.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }
}

