package com.besysoft.bootcampspringboot.utilidades;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResposeHttp {

    public static ResponseEntity<?> badResquest(String mensaje, Object... argumentoFormat) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", String.format(mensaje, argumentoFormat));
        return ResponseEntity.badRequest().body(mensajeBody);
    } //Utilidades respuesta
    public static ResponseEntity<?> badResquest(String mensaje) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", mensaje);
        return ResponseEntity.badRequest().body(mensajeBody);
    } //Utilidades respuesta
    public static ResponseEntity<?> notFound(String mensaje) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", mensaje);
        return new ResponseEntity<>(mensajeBody, headers(), HttpStatus.NOT_FOUND);
    } //Utilidades respuesta
    public static ResponseEntity<?> notFound(String mensaje, String... argumentoFormat) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", String.format(mensaje, argumentoFormat));
        return new ResponseEntity<>(mensajeBody, headers(), HttpStatus.NOT_FOUND);
    } //Utilidades respuesta
    public static ResponseEntity<?> notFound(Object objeto) {
        return new ResponseEntity<>(objeto, headers(), HttpStatus.NOT_FOUND);
    }//Utilidades respuesta
    public static HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");
        return headers;
    } //Utilidades respuesta
}
