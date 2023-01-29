package com.besysoft.bootcampspringboot.utilidades;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.stream.Collectors;

public class DatoDummyn {

    public DatoDummyn() {
    }

    public static  List<Genero> listaDeGeneros = crearDatosGenero();
    public static  List<Personaje> listaDePersonajes = crearPersonajes();

    public static  List<PeliculaSerie> listaDePeliculas = crearPeliculaSerie();

    private static List<Genero> crearDatosGenero() {

        List<PeliculaSerie> listaPeliculaSerieDrama = new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Temblor 1"), buscarPeliSerieEspecial("El Temblor 2"), buscarPeliSerieEspecial("La Esclava")));
        List<PeliculaSerie> listaPeliculaSerieAventura = new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")));
        List<PeliculaSerie> listaPeliculaSerieAccion = new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Rapido y Furioso 1"), buscarPeliSerieEspecial("Rapido y Furioso 2"), buscarPeliSerieEspecial("Rapido y Furioso 3"), buscarPeliSerieEspecial("Rapido y Furioso 4"), buscarPeliSerieEspecial("Rapido y Furioso 30")));
        List<PeliculaSerie> listaPeliculaSerieTerror = new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La Huerfana 1"), buscarPeliSerieEspecial("La Huerfana 2"), buscarPeliSerieEspecial("La Huerfana 3"), buscarPeliSerieEspecial("La Huerfana 4"), buscarPeliSerieEspecial("Juego del Miedo 1"), buscarPeliSerieEspecial("Juego del Miedo 2"), buscarPeliSerieEspecial("Juego del Miedo 3"), buscarPeliSerieEspecial("Juego del Miedo 4")));


        List<Genero> listaDeGeneros = new ArrayList<>(Arrays.asList(new Genero(1L, "Drama", listaPeliculaSerieDrama), new Genero(2L, "Aventura", listaPeliculaSerieAventura), new Genero(3L, "Accion", listaPeliculaSerieAccion), new Genero(4L, "Terror", listaPeliculaSerieTerror)));

        return listaDeGeneros;
    }

    private static List<Personaje> crearPersonajes() {

        List<Personaje> listaPersonajes = new ArrayList<>(Arrays.asList(

                // Personajes de El Temblor 1 y 2.
                new Personaje(10001L, "Jesica", 28, 70F, "Jesica es una chica que vive sola en la casa del pueblo que sus padres le dejaron.", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Temblor 1"), buscarPeliSerieEspecial("El Temblor 2")))),
                new Personaje(10002L, "Oracio", 26, 82F, "Oracio es un chico timido que es el cartero del pueblo.", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Temblor 1"), buscarPeliSerieEspecial("El Temblor 2")))),

                // Personajes de Rapido y Furioso 1, 2, 3, 4 y 30.
                new Personaje(10003L, "La Roca", 45, 102F, "Un tipo rudo que no obedece las reglas, su vida fue siempre muy dura y no le teme al peligro",
                        new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Rapido y Furioso 1"), buscarPeliSerieEspecial("Rapido y Furioso 2"), buscarPeliSerieEspecial("Rapido y Furioso 3"), buscarPeliSerieEspecial("Rapido y Furioso 4"),buscarPeliSerieEspecial("Rapido y Furioso 30")))),
                new Personaje(10004L, "Hernesto Palacio", 40, 78F, "Un hombre comun que viene ed una familia de clase media. Nadacido en Mexico y siempre se mete en problemas",
                        new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Rapido y Furioso 1"), buscarPeliSerieEspecial("Rapido y Furioso 2"), buscarPeliSerieEspecial("Rapido y Furioso 3"), buscarPeliSerieEspecial("Rapido y Furioso 4"),buscarPeliSerieEspecial("Rapido y Furioso 30")))),
                new Personaje(10005L, "Keyti", 35, 68F, "Una chica rebelde que no obedece las reglas, nacida en Miami de familia, es mecanica de niña",
                        new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Rapido y Furioso 1"), buscarPeliSerieEspecial("Rapido y Furioso 2"), buscarPeliSerieEspecial("Rapido y Furioso 3"), buscarPeliSerieEspecial("Rapido y Furioso 4"), buscarPeliSerieEspecial("Rapido y Furioso 30")))),

                // Personajes de Harry Potter 1, 2, 3, 4 y 5.
                new Personaje(10006L, "Harry Potter", 10, 43F, "Harry es un niño hurfano que fue creado por sus tios que lo desprecian por sus habilidades magicas", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                new Personaje(10007L, "Ron Haswich", 10, 45F, "Ron es un niño torpe y despistado, hijo de padres magos que lo aman", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                new Personaje(10008L, "Hermione Jean Granger", 10, 39F, "Hermione es una niña hija de muggles dentistas, sin embargo ella es maga y asiste ala escuela de magia", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                // Personajes La Esclava
                        new Personaje(10009L, "Lisandra", 16, 46F, "Lisandra es una esclava carismatica y hermosa, hija de padres esclavos rebeldes", new ArrayList<>(List.of(buscarPeliSerieEspecial("La esclava")))),
                        new Personaje(10010L, "Lisandro", 18, 58F, "Lisandro es una esclavo rudo y hermoso, hijo de padres esclavos rebeldes", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La esclava")))),
                        new Personaje(10011L, "Hernesto Hernandez", 50, 86F, "Hernesto es un esclavista viudo  y cruel con sus esclavos", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La esclava")))),
                        new Personaje(10012L, "Isaias Norting", 48, 83F, "Isaias es un esclavista hermoso y bueno con sus esclavos", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La esclava")))),

                // Personajes La Huerfana 1, 2 ,3 y 4

                new Personaje(10013L, "Lisa", 13, 38F, "Lisa es un huerfana retraida y timida poseida por un ser maligno", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La huerfana 1"), buscarPeliSerieEspecial("La huerfana 2"), buscarPeliSerieEspecial("La huerfana 3"), buscarPeliSerieEspecial("La huerfana 4")))),



                        // Personajes El juego del miedo 1, 2 , 3 y 4

                new Personaje(10014L, "Julio", 39, 89F, "Julio es un hombre solitario que le gusta ver sufrir a las personas", new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Juego del Miedo 1"), buscarPeliSerieEspecial("El Juego del Miedo 2"), buscarPeliSerieEspecial("El Juego del Miedo 3"),buscarPeliSerieEspecial("El Juego del Miedo 4"))))

        ));

        return listaPersonajes;
    }

    private static List<PeliculaSerie> crearPeliculaSerie() {
        List<PeliculaSerie> listaDePeliculas = new ArrayList<>(Arrays.asList(
                new PeliculaSerie(101L, "El Temblor 1", "2018-02-27", 3),
                new PeliculaSerie(102L, "El Temblor 2", "2021-03-17", 2),

                new PeliculaSerie(103L, "Harry Potter 1", "2000-03-17", 4),
                new PeliculaSerie(104L, "Harry Potter 2", "2002-03-17", 3),
                new PeliculaSerie(105L, "Harry Potter 3", "2006-03-17", 4),
                new PeliculaSerie(106L, "Harry Potter 4", "2011-03-17", 4),
                new PeliculaSerie(107L, "Harry Potter 5", "2015-03-17", 5),

                new PeliculaSerie(108L, "Rapido y Furioso 1", "2015-03-17", 5),
                new PeliculaSerie(109L, "Rapido y Furioso 2", "2015-03-17", 3),
                new PeliculaSerie(110L, "Rapido y Furioso 3", "2015-03-17", 3),
                new PeliculaSerie(111L, "Rapido y Furioso 4", "2015-03-17", 2),
                new PeliculaSerie(112L, "Rapido y Furioso 30", "2015-03-17", 1),

                new PeliculaSerie(113L, "La Esclava", "1999-05-16", 2),
                new PeliculaSerie(114L, "La Huerfana 1", "2010-09-17", 4),
                new PeliculaSerie(115L, "La Huerfana 2", "2011-12-17", 5),
                new PeliculaSerie(116L, "La Huerfana 3", "2012-11-17", 3),
                new PeliculaSerie(117L, "La Huerfana 4", "2016-01-17", 4),

                new PeliculaSerie(118L, "La Huerfana 1", "2015-03-17", 5),
                new PeliculaSerie(119L, "La Huerfana 1", "2015-03-17", 4),
                new PeliculaSerie(120L, "La Huerfana 1", "2015-03-17", 3),
                new PeliculaSerie(121L, "La Huerfana 1", "2015-03-17", 5)));
        return listaDePeliculas;
    }

    public static ResponseEntity<?> agregarNuevoGenero(Genero genero) {

        Map<String, Object> mensajeBody = new HashMap<>();

        Optional<Genero> OptinalGenero = DatoDummyn.listaDeGeneros.stream().filter(p -> p.getNombre().equalsIgnoreCase(genero.getNombre())).findAny();

        if (OptinalGenero.isPresent()) {

            return badResquest("El nombre de genero '%s' ingresado ya existe", genero.getNombre());
        }
        if (genero.getNombre().isBlank() || genero.getNombre() == null) {

            return badResquest("El nombre no puede ser nulo");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");

        Long cantidadDeGeneros = Long.valueOf(DatoDummyn.listaDeGeneros.size());

        genero.setId(cantidadDeGeneros + 1);
        DatoDummyn.listaDeGeneros.add(genero);

        return new ResponseEntity<>(genero, headers, HttpStatus.CREATED);
    }

    public static ResponseEntity<?> badResquest(String mensaje, String... argumentoFormat) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", String.format(mensaje, argumentoFormat));
        return ResponseEntity.badRequest().body(mensajeBody);
    }

    public static ResponseEntity<?> badResquest(String mensaje) {
        Map<String, Object> mensajeBody = new HashMap<>();
        mensajeBody.put("success", Boolean.FALSE);
        mensajeBody.put("mensaje", mensaje);
        return ResponseEntity.badRequest().body(mensajeBody);
    }

    public static ResponseEntity<?> notFound(Object objeto) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");
        return new ResponseEntity<>(objeto, headers, HttpStatus.NOT_FOUND);
    }


    public static ResponseEntity<?> buscarPorTitulo(String titulo) {
        if (titulo == null) {
            return DatoDummyn.badResquest("El titulo no puede ser nulo");
        }

        // Valida letras y numeros para peliculas con numeros.
        Boolean sonSoloLetras = titulo.matches("^[a-zA-Z0-9 ]+$");

        if (!sonSoloLetras) {
            return DatoDummyn.badResquest("Ingrese un titulo valido");
        }

        Optional<PeliculaSerie> OPeliculasSeries = buscarComoRepoTituloPelicula(titulo);


        if (OPeliculasSeries.isEmpty()) {
            return DatoDummyn.notFound(titulo);
        }

        HttpHeaders headers = headers();

        return new ResponseEntity<>(OPeliculasSeries.get(), headers, HttpStatus.CREATED);
    }

    public static ResponseEntity<?> buscarPorGenero(String nombreGenero) {

        if (nombreGenero == null || nombreGenero.isBlank()) {
            return DatoDummyn.badResquest("El nombre del genero no puede ser nulo o estar vacio");
        }

        Boolean sonSoloLetras = nombreGenero.matches("^[a-zA-Z ]+$");

        if (!sonSoloLetras) {
            return DatoDummyn.badResquest("El nombre '%s' no es valido. Ingrese un nombre de genero valido", nombreGenero);
        }

        List<Genero> genero = DatoDummyn.listaDeGeneros.stream().filter(gen -> gen.getNombre().toLowerCase().contains(nombreGenero.toLowerCase())).collect(Collectors.toList());

        /*List<String> listaPeliculasSeries = new ArrayList<>();

        GeneradorDummyn.listaDeGeneros.stream().
                forEach(genero -> {
                    if (genero.getNombre().equalsIgnoreCase(nombreGenero)){
                        listaPeliculasSeries.addAll(genero.getPeliculaSerie());
                    }
                });*/

        if (genero.isEmpty()) {
            return DatoDummyn.notFound(genero);
        }

        HttpHeaders headers = headers();

        return new ResponseEntity<>(genero, headers, HttpStatus.CREATED);
    }

    private static HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");
        return headers;
    }

    public static Optional<PeliculaSerie> buscarComoRepoTituloPelicula(String titulo) {


        return DatoDummyn.listaDePeliculas.stream()
                        .filter(pelis -> pelis.getTitulo().equalsIgnoreCase(titulo))
                        .findAny();
    }

    public static PeliculaSerie buscarPeliSerieEspecial(String titulo) {
        return DatoDummyn.listaDePeliculas.stream()
                .filter(pelis -> pelis.getTitulo().equalsIgnoreCase(titulo))
                .findAny()
                .get();
    }

        /*public static ResponseEntity<?> buscarPorNombre(Object objeto, Class gen){

            if (objeto.getClass().getName().equals(listaDeGeneros.get(0).getClass().getName())){

                gen.getClass() genero = (Genero) objeto; // ******************

                List<Genero> listaGenero = DatoDummyn.listaDeGeneros.stream()
                        .filter(gen -> gen.getNombre().
                                contains(nombreGenero.toLowerCase())).
                        collect(Collectors.toList());
            }

            return null;
        }*/
}
