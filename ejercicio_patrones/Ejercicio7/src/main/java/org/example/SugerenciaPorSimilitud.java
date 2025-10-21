package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SugerenciaPorSimilitud implements tipoSugerencia {

    @Override
    public List<Pelicula> sugerir(Decodificador d) {
        List<Pelicula> listaPeliculas = d.getListaPeliculas();
        List<Pelicula> peliculasReproducidas = d.getPeliculasReproducidas();

         Pelicula peliculaRandom = d.getPeliculaReproducidaRandom();

        if (peliculaRandom != null) { // lo hago asi porque es en el unico caso en el cual puede ser nulo Pelicula
            return listaPeliculas.stream()
                    .filter(p-> !peliculasReproducidas.contains(p))
                    .filter(p -> p.contienePeliculaSimilar(peliculaRandom))
                    .sorted(Comparator.comparing(Pelicula::getFechaEstreno))
                    .limit(3)
                    .toList();
        } else {
            System.out.println("La lista de peliculas esta vacia...");
            return List.of();
        }
    }

}
