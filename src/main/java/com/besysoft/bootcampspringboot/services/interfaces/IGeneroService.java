package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IGeneroService {

    ResponseEntity<List<Genero>> obtenerTodosLosGeneros();
    ResponseEntity<?> agregarNuevoGenero(Genero genero);

    ResponseEntity actualizarGeneroPorId(Long id, Genero generoAct);


}
