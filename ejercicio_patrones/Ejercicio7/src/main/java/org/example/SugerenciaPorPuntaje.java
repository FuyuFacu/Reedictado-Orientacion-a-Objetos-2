package org.example;

import java.util.Comparator;
import java.util.List;

public class SugerenciaPorPuntaje implements tipoSugerencia {

    @Override
    public List<Pelicula> sugerir(Decodificador d) {
        List<Pelicula> listaPeliculas = d.getListaPeliculas();

        return listaPeliculas.stream()
                .sorted(
                        Comparator.comparing(Pelicula::getPuntaje).reversed()
                                .thenComparing(Pelicula::getFechaEstreno)
                )
                .limit(3)
                .toList();
    }

}
