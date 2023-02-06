package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.respositories.interfaces.IGeneroRepository;
import com.besysoft.bootcampspringboot.services.interfaces.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static com.besysoft.bootcampspringboot.utilidades.ResponseHttp.badResquest;
import static com.besysoft.bootcampspringboot.utilidades.ResponseHttp.headers;


@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    IGeneroRepository generoRepository;

    @Override
    public ResponseEntity<?> agregarNuevoGenero(Genero genero) {
        Optional<Genero> optinalGenero = generoRepository.obtenerTodosLosGeneros()
                .stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(genero.getNombre())).findAny();

        if (optinalGenero.isPresent()) {
            return badResquest("El nombre de genero '%s' ingresado ya existe", genero.getNombre());
        }
        if (genero.getNombre().isBlank()) {
            return badResquest("El nombre de genero no puede ser nulo");
        }

        Long cantidadDeGeneros = Long.valueOf(generoRepository.obtenerTodosLosGeneros().size());

        genero.setId(cantidadDeGeneros + 1);
        generoRepository.agregarNuevoGenero(genero);

        return new ResponseEntity<>(genero, headers(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Genero>> obtenerTodosLosGeneros() {
        List<Genero> listaDeGeneros = generoRepository.obtenerTodosLosGeneros();
        return new ResponseEntity<>(listaDeGeneros, headers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity actualizarGeneroPorId(Long id, Genero generoAct) {
        Optional<Genero> optionalGenero = generoRepository.buscarGeneroPorId(id);

        if (optionalGenero.isPresent()) {
            Genero genero = optionalGenero.get();

            if (generoAct.getNombre().isBlank()) {
                return badResquest("El nombre no puede ser nulo o estar vacio");
            }
            if (generoAct.getPeliculaSerie() == null || generoAct.getPeliculaSerie().size()<1){
                return badResquest("Las peliculas sociadas no pueden estar vacias o ser nulas");
            }

            genero.setNombre(generoAct.getNombre());
            genero.setPeliculaSerie(generoAct.getPeliculaSerie());

            return new ResponseEntity(genero, headers(), HttpStatus.OK);
        }else{
            return badResquest("El id %s ingresado no existe", id);
        }
    }
}
