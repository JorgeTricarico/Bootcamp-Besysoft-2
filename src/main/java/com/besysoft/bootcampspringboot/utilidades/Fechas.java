package com.besysoft.bootcampspringboot.utilidades;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Fechas {

    public static LocalDate formatear(String fecha) {

        DateTimeFormatter formateador = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .toFormatter();

        return LocalDate.parse(fecha, formateador);
    }

    /*public static void validarFecha(LocalDate fechaDeCreacion){

        if(fechaDeCreacion == null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"La fecha no puede ser nula.");
            //throw new IllegalArgumentException("La fecha no puede ser nula.");
        }

        if(fechaDeCreacion.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser del futuro.");
        }

    }*/

}
