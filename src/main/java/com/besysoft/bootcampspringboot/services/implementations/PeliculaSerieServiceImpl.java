package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.respositories.interfaces.IPeliculaSerieRepository;
import com.besysoft.bootcampspringboot.services.interfaces.IPeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.besysoft.bootcampspringboot.utilidades.Fechas.formatear;
import static com.besysoft.bootcampspringboot.utilidades.ResponseHttp.*;

@Service
public class PeliculaSerieServiceImpl implements IPeliculaSerieService {

    @Autowired
    IPeliculaSerieRepository peliculaSerieRepository;

    @Override
    public List<PeliculaSerie> obtenerTodasLasPeliculas() {
        return peliculaSerieRepository.obtenerTodasLasPeliculas();
    }

    @Override
    public ResponseEntity<?> buscarPeliculaPorTituloOGenero(String tituloOGenero) {
        if (tituloOGenero == null) {
            return badResquest("El titulo o genero no puede ser nulo");
        }

        // Valida letras y numeros para peliculas con numeros.
        Boolean sonSoloLetras = tituloOGenero.matches("^[a-zA-Z0-9 ]+$");

        if (!sonSoloLetras) {
            return badResquest("Ingrese un titulo o genero valido");
        }

        Optional<PeliculaSerie> OPeliculasSeries = peliculaSerieRepository.buscarTituloDePelicula(tituloOGenero);


        if (OPeliculasSeries.isEmpty()) {
            //return DatoDummyn.notFound("El titulo o genero %s no fue encontrado",titulo);
            List<PeliculaSerie> peliculasPorGenero = peliculaSerieRepository.buscarPeliculaPorGenero(tituloOGenero);
            if (!peliculasPorGenero.isEmpty()){
                return new ResponseEntity<>(peliculasPorGenero, headers(), HttpStatus.OK);
            }else {
                return badResquest("No existe pelicula o genero con el nombre de '%s'", tituloOGenero);
            }
        }

        return new ResponseEntity<>(OPeliculasSeries.get(), headers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> buscarPeliculaPorFecha(String desde, String hasta) {
        LocalDate fechaInicio = formatear(desde);
        LocalDate fechaFinal = formatear(hasta);
        if (desde.compareTo(hasta) > 0) {
            return badResquest("Rango de fecha inválido.");
        }
        List<PeliculaSerie> oPeliculas = peliculaSerieRepository.buscarComoRepoPeliculaPorFecha(fechaInicio,fechaFinal);

        if (oPeliculas.isEmpty()){
            return badResquest("No se encontro peliculas con las fechas ingresadas");
        }


        return new ResponseEntity(oPeliculas, headers(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> buscarPeliculasPorCalificacion(Integer desde, Integer hasta) {
        if (desde == null || hasta == null){
            return badResquest("Las calificaciones no pueden ser nulas");
        }
        if (desde < 1 || desde > 5 || hasta < 1 || hasta > 5) {
            return badResquest("Las calificaciones debe ser del 1 al 5");
        }
        if (!(desde<=hasta)){
            return badResquest("Las calificaciones desde y hasta deben ser iguales o en orden ascendente");
        }

        List<PeliculaSerie> peliculas = peliculaSerieRepository.buscarPeliculasPorCalificaciones(desde, hasta);

        if(peliculas.isEmpty()){
            return badResquest("No se encontro peliculas con las calificaciones indicadas");
        }


        return new ResponseEntity(peliculas, headers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity agregarNuevaPelicula(PeliculaSerie pelicula) {

        Optional<PeliculaSerie> optionalPelicula = peliculaSerieRepository.obtenerTodasLasPeliculas()
                .stream().filter(p -> p.getTitulo().equalsIgnoreCase(pelicula.getTitulo()))
                .findAny();

        if (optionalPelicula.isPresent()) {
            return badResquest("El nombre de pelicula o serie '%s' ingresado ya existe", pelicula.getTitulo());
        }
        if (pelicula.getFechaDeCreacion() == null){
            return badResquest("La fecha de creacion no puede ser nula o estar vacia.");
        }
        if (pelicula.getTitulo().isBlank() || pelicula.getTitulo() == null) {
            return badResquest("El nombre de pelicula no puede ser nulo");
        }


        Long cantidadDePeliculas = Long.valueOf(peliculaSerieRepository.obtenerTodasLasPeliculas().size());

        pelicula.setId(cantidadDePeliculas + 101);
        peliculaSerieRepository.agregarNuevaPelicula(pelicula);

        return new ResponseEntity(pelicula, headers(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity actualizarPeliculaPorId(Long id, PeliculaSerie peliculaSerie) {
        Optional<PeliculaSerie> optionalPelicula = peliculaSerieRepository.buscarPeliculaPorId(id);

        if(optionalPelicula.isPresent()){
            PeliculaSerie pelicula = optionalPelicula.get();

            if(peliculaSerie.getTitulo().isBlank()) {
                return badResquest("El titulo no puede ser nulo o estar vacio");
            }
            if(peliculaSerie.getCalificacion() == null) {
                return badResquest("La calificacion no puede ser nula");
            }
            if(peliculaSerie.getFechaDeCreacion() == null) {
                return badResquest("La fecha de creacion no puede ser nula");
            }
            pelicula.setTitulo(peliculaSerie.getTitulo());
            pelicula.setCalificacion(peliculaSerie.getCalificacion());
            pelicula.setFechaDeCreacion(peliculaSerie.getFechaDeCreacion());

            return new ResponseEntity(pelicula, headers(), HttpStatus.OK);
        } else {
            return badResquest("El id %s ingresado no existe", id);
        }
    }


}
