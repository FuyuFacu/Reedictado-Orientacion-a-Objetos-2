package org.example;

import java.util.Comparator;
import java.util.List;

public class SugerenciaPorNovedad implements tipoSugerencia {

    @Override
    public List<Pelicula> sugerir(Decodificador d) {
        List<Pelicula> lista = d.getListaPeliculas();
        List<Pelicula> peliculasReproducidas = d.getPeliculasReproducidas();

        return lista.stream()
                .filter(p-> !peliculasReproducidas.contains(p))
                .sorted(Comparator.comparing(Pelicula::getFechaEstreno))
                .limit(3)
                .toList();
    }

}
