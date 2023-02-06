package com.besysoft.bootcampspringboot.respositories.implementations;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.respositories.interfaces.IGeneroRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GeneroRepositoryImpl implements IGeneroRepository {

    private List<Genero> listaDeGeneros = IGeneroRepository.crearDatosGenero();

    @Override
    public void agregarNuevoGenero(Genero genero) {
        listaDeGeneros.add(genero);
    }

    @Override
    public List<Genero> obtenerTodosLosGeneros() {
        return listaDeGeneros;
    }

    @Override
    public Optional<Genero> buscarGeneroPorId(Long id) {
        return listaDeGeneros.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }
}

