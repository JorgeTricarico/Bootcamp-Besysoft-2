package com.besysoft.bootcampspringboot.respositories.interfaces;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.utilidades.DatoDummyn;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public interface IPersonajeRepository {

    static List<Personaje> crearPersonajes() {

        /*listaDePeliculas.stream().forEach(peliculaSerie ->
                peliculaSerie.getPersonajesAsociados().forEach(personaje ->
                        personaje.getPeliculaSerieAsociada().add(peliculaSerie))
        );*/

        List<Personaje> listaPersonajes = IPeliculaSerieRepository.crearPeliculaSerie()
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
    }

    List<Personaje> obtenerTodosLosPersonajes();
    void agregarNuevoPersonaje(Personaje personaje);
    Optional<Personaje> buscarPersonajePorNombre(String nombre);


        Optional<Personaje> buscarPersonajesPorEdad(Integer edad);
    List<Personaje> buscarPersonajesPorRangoDeEdad(Integer desde, Integer hasta);
    Optional<Personaje> buscarPersonajePorId(Long id);

}
