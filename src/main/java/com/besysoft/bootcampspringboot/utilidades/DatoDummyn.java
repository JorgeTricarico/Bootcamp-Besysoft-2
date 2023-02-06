package com.besysoft.bootcampspringboot.utilidades;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.PeliculaSerie;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Deprecated
public class DatoDummyn {



    public DatoDummyn() {
    }

    public static  List<Genero> listaDeGeneros = crearDatosGenero();
    public static  List<PeliculaSerie> listaDePeliculas = crearPeliculaSerie();
    public static  List<Personaje> listaDePersonajes = crearPersonajes();





    private static List<Genero> crearDatosGenero() {

        List<String> listaPeliculaSerieDrama = new ArrayList<>(Arrays.asList(("El Temblor 1"), ("El Temblor 2"), ("La Esclava")));
        List<String> listaPeliculaSerieAventura = new ArrayList<>(Arrays.asList(("Harry Potter 1"), ("Harry Potter 2"), ("Harry Potter 3"), ("Harry Potter 4"),("Harry Potter 5")));
        List<String> listaPeliculaSerieAccion = new ArrayList<>(Arrays.asList(("Rapido y Furioso 1"), ("Rapido y Furioso 2"), ("Rapido y Furioso 3"), ("Rapido y Furioso 4"), ("Rapido y Furioso 30")));
        List<String> listaPeliculaSerieTerror = new ArrayList<>(Arrays.asList(("La Huerfana 1"), ("La Huerfana 2"), ("La Huerfana 3"), ("La Huerfana 4"), ("Juego del Miedo 1"), ("Juego del Miedo 2"), ("Juego del Miedo 3"), ("Juego del Miedo 4")));


        List<Genero> listaDeGeneros = new ArrayList<>(Arrays.asList(new Genero(1L, "Drama", listaPeliculaSerieDrama), new Genero(2L, "Aventura", listaPeliculaSerieAventura), new Genero(3L, "Accion", listaPeliculaSerieAccion), new Genero(4L, "Terror", listaPeliculaSerieTerror)));

        return listaDeGeneros;
    } //GeneroRepository

    private static List<Personaje> crearPersonajes() {

        /*listaDePeliculas.stream().forEach(peliculaSerie ->
                peliculaSerie.getPersonajesAsociados().forEach(personaje ->
                        personaje.getPeliculaSerieAsociada().add(peliculaSerie))
        );*/

        List<Personaje> listaPersonajes = listaDePeliculas
                .stream()
                    .flatMap(peliculaSerie -> peliculaSerie.getPersonajesAsociados().stream())
                    .distinct()
                    .collect(Collectors.toList());




        /*List<Personaje> listaPersonajes = new ArrayList<>(Arrays.asList(

                // Personajes de El Temblor 1 y 2.
                new Personaje(10001L, "Jesica", 28, 70F, "Jesica es una chica que vive sola en la casa del pueblo que sus padres le dejaron.", null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Temblor 1"), buscarPeliSerieEspecial("El Temblor 2")))),
                new Personaje(10002L, "Oracio", 26, 82F, "Oracio es un chico timido que es el cartero del pueblo.", null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Temblor 1"), buscarPeliSerieEspecial("El Temblor 2")))),

                // Personajes de Rapido y Furioso 1, 2, 3, 4 y 30.
                new Personaje(10003L, "La Roca", 45, 102F, "Un tipo rudo que no obedece las reglas, su vida fue siempre muy dura y no le teme al peligro",
                        null),
                new Personaje(10004L, "Hernesto Palacio", 40, 78F, "Un hombre comun que viene ed una familia de clase media. Nadacido en Mexico y siempre se mete en problemas",
                        null),
                new Personaje(10005L, "Keyti", 35, 68F, "Una chica rebelde que no obedece las reglas, nacida en Miami de familia, es mecanica de niña",
                        null),

                // Personajes de Harry Potter 1, 2, 3, 4 y 5.
                new Personaje(10006L, "Harry Potter", 10, 43F, "Harry es un niño hurfano que fue creado por sus tios que lo desprecian por sus habilidades magicas",
                        null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                new Personaje(10007L, "Ron Haswich", 10, 45F, "Ron es un niño torpe y despistado, hijo de padres magos que lo aman",
                        null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                new Personaje(10008L, "Hermione Jean Granger", 10, 39F, "Hermione es una niña hija de muggles dentistas, sin embargo ella es maga y asiste ala escuela de magia",
                        null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("Harry Potter 1"), buscarPeliSerieEspecial("Harry Potter 2"), buscarPeliSerieEspecial("Harry Potter 3"), buscarPeliSerieEspecial("Harry Potter 4"),buscarPeliSerieEspecial("Harry Potter 5")))),

                // Personajes La Esclava
                        new Personaje(10009L, "Lisandra", 16, 46F, "Lisandra es una esclava carismatica y hermosa, hija de padres esclavos rebeldes",
                                null),
                        new Personaje(10010L, "Lisandro", 18, 58F, "Lisandro es una esclavo rudo y hermoso, hijo de padres esclavos rebeldes",
                                null),
                        new Personaje(10011L, "Hernesto Hernandez", 50, 86F, "Hernesto es un esclavista viudo  y cruel con sus esclavos",
                                null),
                        new Personaje(10012L, "Isaias Norting", 48, 83F, "Isaias es un esclavista hermoso y bueno con sus esclavos",
                                null),

                // Personajes La Huerfana 1, 2 ,3 y 4

                new Personaje(10013L, "Lisa", 13, 38F, "Lisa es un huerfana retraida y timida poseida por un ser maligno",
                        null),//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("La huerfana 1"), buscarPeliSerieEspecial("La huerfana 2"), buscarPeliSerieEspecial("La huerfana 3"), buscarPeliSerieEspecial("La huerfana 4")))),



                        // Personajes El juego del miedo 1, 2 , 3 y 4

                new Personaje(10014L, "Julio", 39, 89F, "Julio es un hombre solitario que le gusta ver sufrir a las personas",
                        null)//new ArrayList<>(Arrays.asList(buscarPeliSerieEspecial("El Juego del Miedo 1"), buscarPeliSerieEspecial("El Juego del Miedo 2"), buscarPeliSerieEspecial("El Juego del Miedo 3"),buscarPeliSerieEspecial("El Juego del Miedo 4"))))

        ));*/

        return listaPersonajes;
    } //PersonajeRepository

    private static List<PeliculaSerie> crearPeliculaSerie() {


        Personaje jesica = new Personaje(10001L, "Jesica", 28, 70F, "Jesica es una chica que vive sola en la casa del pueblo que sus padres le dejaron.", null);
        Personaje oracio = new Personaje(10002L, "Oracio", 26, 82F, "Oracio es un chico timido que es el cartero del pueblo.", null);

        Personaje harry = new Personaje(10006L, "Harry Potter", 10, 43F, "Harry es un niño hurfano que fue creado por sus tios que lo desprecian por sus habilidades magicas",null);
        Personaje ron = new Personaje(10007L, "Ron Haswich", 10, 45F, "Ron es un niño torpe y despistado, hijo de padres magos que lo aman", null);
        Personaje hermanione = new Personaje(10008L, "Hermione Jean Granger", 10, 39F, "Hermione es una niña hija de muggles dentistas, sin embargo ella es maga y asiste ala escuela de magia", null);

        Personaje la_roca = new Personaje(10003L, "La Roca", 45, 102F, "Un tipo rudo que no obedece las reglas, su vida fue siempre muy dura y no le teme al peligro", null);
        Personaje hernestoPalacio = new Personaje(10004L, "Hernesto Palacio", 40, 78F, "Un hombre comun que viene ed una familia de clase media. Nadacido en Mexico y siempre se mete en problemas", null);
        Personaje keyti = new Personaje(10005L, "Keyti", 35, 68F, "Una chica rebelde que no obedece las reglas, nacida en Miami de familia, es mecanica de niña", null);


        Personaje lisandra = new Personaje(10009L, "Lisandra", 16, 46F, "Lisandra es una esclava carismatica y hermosa, hija de padres esclavos rebeldes", null);
        Personaje lisandro = new Personaje(10010L, "Lisandro", 18, 58F, "Lisandro es una esclavo rudo y hermoso, hijo de padres esclavos rebeldes", null);
        Personaje hernestoHernandez = new Personaje(10011L, "Hernesto Hernandez", 50, 86F, "Hernesto es un esclavista viudo  y cruel con sus esclavos", null);
        Personaje isaias = new Personaje(10012L, "Isaias Norting", 48, 83F, "Isaias es un esclavista hermoso y bueno con sus esclavos", null);

        Personaje lisa = new Personaje(10013L, "Lisa", 13, 38F, "Lisa es un huerfana retraida y timida poseida por un ser maligno", null);

        Personaje julio = new Personaje(10014L, "Julio", 39, 89F, "Julio es un hombre solitario que le gusta ver sufrir a las personas", null);

        PeliculaSerie elTemblor1 = new PeliculaSerie(101L, "El Temblor 1", "27-02-2018", 3, new ArrayList<>(Arrays.asList(
                jesica, oracio)));
        PeliculaSerie elTemblor2 = new PeliculaSerie(102L, "El Temblor 2", "17-03-2021", 2, new ArrayList<>(Arrays.asList(
                jesica, oracio)));

        PeliculaSerie harryPotter1 = new PeliculaSerie(103L, "Harry Potter 1", "17-03-2003", 4, new ArrayList<>(Arrays.asList(
                harry, ron, hermanione)));
        PeliculaSerie harryPotter2 = new PeliculaSerie(104L, "Harry Potter 2", "17-03-2005", 3, new ArrayList<>(Arrays.asList(
                harry, ron, hermanione)));
        PeliculaSerie harryPotter3 = new PeliculaSerie(105L, "Harry Potter 3", "17-03-2007", 4, new ArrayList<>(Arrays.asList(
                harry, ron, hermanione)));
        PeliculaSerie harryPotter4 = new PeliculaSerie(106L, "Harry Potter 4", "17-03-2009", 4, new ArrayList<>(Arrays.asList(
                harry, ron, hermanione)));
        PeliculaSerie harryPotter5 = new PeliculaSerie(107L, "Harry Potter 5", "17-03-2012", 5, new ArrayList<>(Arrays.asList(
                harry, ron, hermanione)));

        PeliculaSerie rapidoYFurioso1 = new PeliculaSerie(108L, "Rapido y Furioso 1", "17-03-1999", 5, new ArrayList<>(Arrays.asList(
                la_roca, hernestoPalacio, keyti)));
        PeliculaSerie rapidoYFurioso2 = new PeliculaSerie(109L, "Rapido y Furioso 2", "19-06-2003", 3, new ArrayList<>(Arrays.asList(
                la_roca, hernestoPalacio, keyti)));
        PeliculaSerie rapidoYFurioso3 = new PeliculaSerie(110L, "Rapido y Furioso 3", "07-01-2008", 3, new ArrayList<>(Arrays.asList(
                la_roca, hernestoPalacio, keyti)));
        PeliculaSerie rapidoYFurioso4 = new PeliculaSerie(111L, "Rapido y Furioso 4", "17-03-2009", 2, new ArrayList<>(Arrays.asList(
                la_roca, hernestoPalacio, keyti)));
        PeliculaSerie rapidoYFurioso30 = new PeliculaSerie(112L, "Rapido y Furioso 30", "17-03-2015", 1, new ArrayList<>(Arrays.asList(
                la_roca, hernestoPalacio, keyti)));

        PeliculaSerie laEsclava = new PeliculaSerie(113L, "La Esclava", "25-09-2015", 2, new ArrayList<>(Arrays.asList(
                lisandra, lisandro, hernestoHernandez, isaias)));
        PeliculaSerie laHuerfana1 = new PeliculaSerie(114L, "La Huerfana 1", "01-08-2003", 4, new ArrayList<>(Arrays.asList(
                lisa)));
        PeliculaSerie laHuerfana2 = new PeliculaSerie(115L, "La Huerfana 2", "09-07-2005", 5, new ArrayList<>(Arrays.asList(
                lisa)));
        PeliculaSerie laHuerfana3 = new PeliculaSerie(116L, "La Huerfana 3", "17-02-2010", 3, new ArrayList<>(Arrays.asList(
                lisa)));
        PeliculaSerie laHuerfana4 = new PeliculaSerie(117L, "La Huerfana 4", "29-07-2013", 4, new ArrayList<>(Arrays.asList(
                lisa)));

        PeliculaSerie elJuegoDelMiedo1 = new PeliculaSerie(118L, "El Juego del Miedo 1", "15-04-2001", 5, new ArrayList<>(Arrays.asList(
                julio)));
        PeliculaSerie elJuegoDelMiedo2 = new PeliculaSerie(119L, "El Juego del Miedo 2", "17-08-2008", 4, new ArrayList<>(Arrays.asList(
                julio)));
        PeliculaSerie elJuegoDelMiedo3 = new PeliculaSerie(120L, "El Juego del Miedo 3", "17-09-2014", 3, new ArrayList<>(Arrays.asList(
                julio)));
        PeliculaSerie elJuegoDelMiedo4 = new PeliculaSerie(121L, "El Juego del Miedo 4", "17-11-2018", 5, new ArrayList<>(Arrays.asList(
                julio)));



        List<PeliculaSerie> listaDePeliculas = new ArrayList<>(Arrays.asList(
                elTemblor1,elTemblor2,harryPotter1,harryPotter2,harryPotter3,harryPotter4,harryPotter5,rapidoYFurioso1,rapidoYFurioso2,rapidoYFurioso3,rapidoYFurioso4,rapidoYFurioso30,
                laEsclava, laHuerfana1,laHuerfana2,laHuerfana3,laHuerfana4,elJuegoDelMiedo1,elJuegoDelMiedo2,elJuegoDelMiedo3,elJuegoDelMiedo4));

        return listaDePeliculas;
    } //PeliculaRepository

    public static ResponseEntity<?> agregarNuevoGenero(Genero genero) {

        Optional<Genero> OptinalGenero = listaDeGeneros.stream().filter(p -> p.getNombre().equalsIgnoreCase(genero.getNombre())).findAny();

        if (OptinalGenero.isPresent()) {
            return badResquest("El nombre de genero '%s' ingresado ya existe", genero.getNombre());
        }
        if (genero.getNombre().isBlank() || genero.getNombre() == null) {
            return badResquest("El nombre de genero no puede ser nulo");
        }

        Long cantidadDeGeneros = Long.valueOf(DatoDummyn.listaDeGeneros.size());

        genero.setId(cantidadDeGeneros + 1);
        DatoDummyn.listaDeGeneros.add(genero);

        return new ResponseEntity<>(genero, headers(), HttpStatus.CREATED);
    } // GeneroService

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

    // Respuestas NotFound
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


    public static ResponseEntity<?> buscarPeliculaPorTitulobuscarPeliculaPorTituloOGenero(String tituloOGenero) {
        if (tituloOGenero == null) {
            return DatoDummyn.badResquest("El titulo o genero no puede ser nulo");
        }

        // Valida letras y numeros para peliculas con numeros.
        Boolean sonSoloLetras = tituloOGenero.matches("^[a-zA-Z0-9 ]+$");

        if (!sonSoloLetras) {
            return DatoDummyn.badResquest("Ingrese un titulo o genero valido");
        }

        Optional<PeliculaSerie> OPeliculasSeries = buscarComoRepoTituloPelicula(tituloOGenero);


        if (OPeliculasSeries.isEmpty()) {
            //return DatoDummyn.notFound("El titulo o genero %s no fue encontrado",titulo);
            List<PeliculaSerie> peliculasPorGenero = buscarComoRepoPeliculaPorGenero(tituloOGenero);
            if (!peliculasPorGenero.isEmpty()){
                return new ResponseEntity<>(peliculasPorGenero, headers(), HttpStatus.OK);
            }else {
                return badResquest("No existe pelicula o genero con el nombre de '%s'", tituloOGenero);
            }
        }

        return new ResponseEntity<>(OPeliculasSeries.get(), headers(), HttpStatus.OK);
    } //PeliculaService



    private static HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");
        return headers;
    } //Utilidades respuesta

    public static Optional<PeliculaSerie> buscarComoRepoTituloPelicula(String titulo) {


        return DatoDummyn.listaDePeliculas.stream()
                        .filter(pelis -> pelis.getTitulo().equalsIgnoreCase(titulo))
                        .findAny();
    } //PeliculaRepository



    public static ResponseEntity<?> buscarPorEdadONombre(String dato) {
        if (dato == null || dato.isBlank()) {
            return DatoDummyn.badResquest("El dato ingresado no puede ser nulo o estar vacio");
        }
        if (!dato.matches("^[a-zA-Z ]+$")) {
            DatoDummyn.badResquest("El dato ingresado no es valido, solo letras para personajes o numeros para edades");
        }

        if (dato.matches("^[0-9]+$")) {
            Integer datoAInteger = Integer.parseInt(dato);
            return buscarPersonajesPorEdad(datoAInteger);
        } else {
            return buscarPersonajePorNombre(dato);
        }
    } //PersonajeService

    private static Optional<Personaje> buscarComoRepoPersonajePorNombre(String nombre){
        return DatoDummyn.listaDePersonajes.stream()
                .filter(pelis -> pelis.getNombre().equalsIgnoreCase(nombre))
                .distinct()
                .findAny();
    } //PesonajeRepository

    public static ResponseEntity<?> buscarPersonajePorNombre( String nombre) {

        Boolean sonSoloLetras = nombre.matches("^[a-zA-Z ]+$");

        if (!sonSoloLetras) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Personaje> oPersonaje = buscarComoRepoPersonajePorNombre(nombre);
        if (oPersonaje.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Personaje personaje = oPersonaje.get();
        HttpHeaders headers = headers();
        return new ResponseEntity<>(personaje, headers, HttpStatus.CREATED);
    } //PersonajeService

    public static ResponseEntity<?> buscarPersonajesPorEdad(Integer edad) {

        Optional<Personaje> oPersonaje= buscarComoRepoPersonajesPorEdad(edad);

        if (oPersonaje.isEmpty()) {
            return notFound("La edad ingresada no corresponde con ningun personaje");
        }
        Personaje personaje = oPersonaje.get();

        return new ResponseEntity<>(personaje,headers(),HttpStatus.ACCEPTED);
    } //PersonajeService

    public static Optional<Personaje> buscarComoRepoPersonajesPorEdad(Integer edad){
        // Busca algun nombre que contenga la el string {nombre}
        return DatoDummyn.listaDePersonajes.stream()
                .filter(personaje -> personaje.getEdad() == edad)
                .findAny();
    } //PersonajeRepository

    public static List<PeliculaSerie> buscarComoRepoPeliculaPorGenero (String nombreDeGenero){

        /*return DatoDummyn.listaDeGeneros
                .stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreDeGenero))
                .findAny();*/

        Optional<Genero> oGenero = DatoDummyn.listaDeGeneros
                .stream()
                .filter(genero -> genero.getNombre().equalsIgnoreCase(nombreDeGenero))
                .findAny();

        if (oGenero.isPresent()){
            return oGenero.get().getPeliculaSerie().stream().map(p-> buscarComoRepoTituloPelicula(p).get()).collect(Collectors.toList());
        }
        return null;
    } //PeliculaRepository

    public static ResponseEntity<List<Genero>> obtenerTodosLosGeneros(){

        List<Genero> listaGeneros = DatoDummyn.listaDeGeneros;
        return new ResponseEntity<>(listaGeneros, headers(), HttpStatus.OK);
    } //GeneroService

    public static ResponseEntity<?> buscarPeliculaPorFecha(String desde, String hasta) {

        LocalDate fechaInicio = formatear(desde);
        LocalDate fechaFinal = formatear(hasta);

        List<PeliculaSerie> oPeliculas = buscarComoRepoPeliculaPorFecha(fechaInicio,fechaFinal);

        if (oPeliculas.isEmpty()){
            return badResquest("No se encontro peliculas con las fechas ingresadas");
        }


        return new ResponseEntity(oPeliculas, headers(), HttpStatus.ACCEPTED);
    } //ServiceRepository

    public static LocalDate formatear(String fecha) {

        DateTimeFormatter formateador = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .toFormatter();

        return LocalDate.parse(fecha, formateador);
    }

    public static void validarFecha(LocalDate fechaDeCreacion){

        if(fechaDeCreacion == null){
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }

        if(fechaDeCreacion.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser del futuro.");
        }

    }



    public static  List<PeliculaSerie> buscarComoRepoPeliculaPorFecha(LocalDate fechaInicio, LocalDate fechaFinal){

        return listaDePeliculas.stream()
                .filter(ps -> ps.getFechaDeCreacion().isAfter(fechaInicio.minusDays(1))
                        && ps.getFechaDeCreacion().isBefore(fechaFinal.plusDays(1)))
                .collect(Collectors.toList());
    } //PeliculaResposotory

    public static  List<PeliculaSerie> buscarComoRepoPeliculasPorCalificaciones(Integer desde, Integer hasta) {
        return listaDePeliculas.stream()
                .filter(ps -> ps.getCalificacion() >= desde && ps.getCalificacion()<= hasta)
                .collect(Collectors.toList());
    } //PeliculaRespository

    public static ResponseEntity<?> buscarPeliculasPorCalificacion(Integer desde, Integer hasta){
        if (desde == null || hasta == null){
            return badResquest("Las calificaciones no pueden ser nulas");
        }
        if (desde < 1 || desde > 5 || hasta < 1 || hasta > 5) {
            return badResquest("Las calificaciones debe ser del 1 al 5");
        }
        if (!(desde<=hasta)){
            return badResquest("Las calificaciones desde y hasta deben ser iguales o en orden ascendente");
        }

        List<PeliculaSerie> peliculas = buscarComoRepoPeliculasPorCalificaciones(desde, hasta);

        if(peliculas.isEmpty()){
            return badResquest("No se encontro peliculas con las calificaciones indicadas");
        }


        return new ResponseEntity(peliculas, headers(), HttpStatus.OK);
    } //PeliculaService

    public static ResponseEntity<?> buscarPersonajePorRangoDeEdad(Integer desde, Integer hasta){
        if (desde == null || hasta == null){
            return badResquest("La edad no pueden ser nulas");
        }
        if (desde < 0 || hasta < 0) {
            return badResquest("Las edades debe ser mayores a 0");
        }
        if (!(desde<=hasta)){
            return badResquest("Las edades desde y hasta deben ser iguales o en orden ascendente");
        }

        List<Personaje> personajes = buscarComoRepoPersonajesPorRangoDeEdad(desde, hasta);

        if (personajes.isEmpty()) {
            return badResquest("No se encontro personajes con el rango indicado de edad");
        }

        return new ResponseEntity(personajes, headers(), HttpStatus.OK);
    }   //PersonajeService

    public static List<Personaje> buscarComoRepoPersonajesPorRangoDeEdad(Integer desde, Integer hasta){
        return listaDePersonajes.stream()
                .filter(p -> p.getEdad() >= desde && p.getEdad() <= hasta)
                .collect(Collectors.toList());
    } //PersonajeRepository

    public static ResponseEntity agregarNuevaPelicula(PeliculaSerie pelicula){

        Optional<PeliculaSerie> optionalPelicula = listaDePeliculas.stream().filter(p -> p.getTitulo().equalsIgnoreCase(pelicula.getTitulo())).findAny();

        if (optionalPelicula.isPresent()) {
            return badResquest("El nombre de pelicula o serie '%s' ingresado ya existe", pelicula.getTitulo());
        }
        if (pelicula.getTitulo().isBlank() || pelicula.getTitulo() == null) {
            return badResquest("El nombre de pelicula no puede ser nulo");
        }

        Long cantidadDePeliculas = Long.valueOf(DatoDummyn.listaDePeliculas.size());

        pelicula.setId(cantidadDePeliculas + 101);
        listaDePeliculas.add(pelicula);

        return new ResponseEntity(pelicula, headers(), HttpStatus.CREATED);
    } //PeliculaService

    public static ResponseEntity agregarNuevoPersonaje(Personaje personaje){

        Optional<Personaje> optionalPersonaje = listaDePersonajes.stream().filter(p -> p.getNombre().equalsIgnoreCase(personaje.getNombre())).findAny();

        if (optionalPersonaje.isPresent()) {
            return badResquest("El nombre del personaje '%s' ingresado ya existe", personaje.getNombre());
        }
        if (personaje.getNombre().isBlank() || personaje.getNombre() == null) {
            return badResquest("El nombre del personaje no puede estar vacio o ser nulo");
        }
        if (personaje.getEdad()>=0 || personaje.getEdad() == null){
            return badResquest("La edad no puede ser negativa o nula");
        }
        if (personaje.getPeso()>0 || personaje.getPeso() == null) {
            return badResquest("El peso no puede ser negativo o nulo");
        }
        if (!personaje.getHistoria().isBlank() || personaje.getHistoria() == null) {
            return badResquest("La hisotira del personaje no puede estar vacia o ser nula");
        }

        Long cantidadDePersonajes = Long.valueOf(DatoDummyn.listaDePersonajes.size());

        personaje.setId(cantidadDePersonajes + 10001);
        listaDePersonajes.add(personaje);


        return new ResponseEntity(personaje, headers(), HttpStatus.CREATED);
    } //PersonajeService

    public static ResponseEntity actualizarPeliculaPorId(Long id, PeliculaSerie peliculaSerie) {

        Optional<PeliculaSerie> optionalPelicula = buscarComoRepoPeliculaPorID(id);

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

    } //PeliculaService

    public static Optional<PeliculaSerie> buscarComoRepoPeliculaPorID(Long id){
        return listaDePeliculas.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    } //PeliculaRepository

    public static ResponseEntity actualizarPersonajePorId(Long id, Personaje personajeAct){
        Optional<Personaje> optionalPersonaje = buscarComoRepoPersonajePorID(id);

        if (optionalPersonaje.isPresent()) {
            Personaje personaje = optionalPersonaje.get();

            if (personajeAct.getNombre().isBlank()) {
                return badResquest("El nombre no puede estar vacio o nulo");
            }
            if (personajeAct.getEdad() == null){
                return badResquest("La edad no puede ser nula");
            }
            if (personajeAct.getPeso() == null) {
                return badResquest("El peso no puede ser nulo");
            }
            if (personajeAct.getHistoria().isBlank()) {
                return badResquest("La historia no puede ser nula o estar vacia");
            }

            personaje.setNombre(personajeAct.getNombre());
            personaje.setEdad(personajeAct.getEdad());
            personaje.setPeso(personajeAct.getPeso());
            personaje.setHistoria(personajeAct.getHistoria());

            if (personajeAct.getPeliculaSerieAsociada().size()>0){
                personaje.setPeliculaSerieAsociada(personajeAct.getPeliculaSerieAsociada());
            }

            return new ResponseEntity(personaje, headers(), HttpStatus.OK);
        }else{
            return badResquest("El id %s ingresado no existe", id);
        }
    } //PersonajeService

    public static ResponseEntity actualizarGeneroPorId(Long id, Genero generoAct){
        Optional<Genero> optionalGenero = buscarComoRepoGeneroPorID(id);

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
    } //GeneroService

    public static Optional<Personaje> buscarComoRepoPersonajePorID(Long id){
        return listaDePersonajes.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    } //PersonajeRepository

    public static Optional<Genero> buscarComoRepoGeneroPorID(Long id){
        return listaDeGeneros.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    } //GeneroRepository


}
