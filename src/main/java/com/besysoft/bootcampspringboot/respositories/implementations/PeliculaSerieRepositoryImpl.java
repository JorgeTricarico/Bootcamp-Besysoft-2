package com.besysoft.bootcampspringboot.respositories.implementations;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.respositories.interfaces.IGeneroRepository;
import com.besysoft.bootcampspringboot.respositories.interfaces.IPeliculaSerieRepository;
import com.besysoft.bootcampspringboot.services.interfaces.IPeliculaSerieService;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PeliculaSerieRepositoryImpl implements IPeliculaSerieRepository {


    List<PeliculaSerie> listaDePeliculas = IPeliculaSerieRepository.crearPeliculaSerie();


    @Override
    public List<PeliculaSerie> obtenerTodasLasPeliculas() {
        return listaDePeliculas;
    }

    @Override
    public List<PeliculaSerie> buscarPeliculaPorGenero (String nombreDeGenero){

        /*return DatoDummyn.listaDeGeneros
                .stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreDeGenero))
                .findAny();*/

        Optional<Genero> oGenero = IGeneroRepository.crearDatosGenero()
                .stream()
                .filter(genero -> genero.getNombre().equalsIgnoreCase(nombreDeGenero))
                .findAny();

        if (oGenero.isPresent()){
            return oGenero.get().getPeliculaSerie().stream().map(p-> buscarTituloDePelicula(p).get()).collect(Collectors.toList());
        }
        return null;
    }
    @Override
    public List<PeliculaSerie> buscarPeliculasPorCalificaciones(Integer desde, Integer hasta) {
        return listaDePeliculas.stream()
                .filter(ps -> ps.getCalificacion() >= desde && ps.getCalificacion()<= hasta)
                .collect(Collectors.toList());
    }

    @Override
    public List<PeliculaSerie> buscarComoRepoPeliculaPorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        return listaDePeliculas.stream()
                .filter(ps -> ps.getFechaDeCreacion().isAfter(fechaInicio.minusDays(1))
                        && ps.getFechaDeCreacion().isBefore(fechaFinal.plusDays(1)))
                .collect(Collectors.toList());
    }

    @Override
    public void agregarNuevaPelicula(PeliculaSerie peliculaSerie) {
        listaDePeliculas.add(peliculaSerie);
    }

    @Override
    public Optional<PeliculaSerie> buscarTituloDePelicula(String titulo) {
        return listaDePeliculas.stream()
                .filter(pelis -> pelis.getTitulo().equalsIgnoreCase(titulo))
                .findAny();
    }

    @Override
    public Optional<PeliculaSerie> buscarPeliculaPorId(Long id) {
        return listaDePeliculas.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }

}
