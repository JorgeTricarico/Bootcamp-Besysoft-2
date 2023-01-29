package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/genero")
public class GeneroControlador {

    @PostMapping
    public ResponseEntity<?> agregarNuevoGenero(@RequestBody Genero genero) {

        Map<String, Object> mensajeBody = new HashMap<>();

        Optional<Genero> OptinalGenero = DatoDummyn.listaDeGeneros.stream().
                filter(p -> p.getNombre().equalsIgnoreCase(genero.getNombre()))
                .findAny();

        if (OptinalGenero.isPresent()) {
            mensajeBody.put("success", Boolean.FALSE);
            mensajeBody.put("mensaje", String.
                    format("El genero '%s' ya existe", genero.getNombre()));
            return ResponseEntity.
                    badRequest().
                    body(mensajeBody);
        }


        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");

        Long cantidadDeGeneros = Long.valueOf(DatoDummyn.listaDeGeneros.size());

        genero.setId(cantidadDeGeneros + 1);
        DatoDummyn.listaDeGeneros.add(genero);

        return new ResponseEntity<Genero>(genero, headers, HttpStatus.CREATED);
    }


}
