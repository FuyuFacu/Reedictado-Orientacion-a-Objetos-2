package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Decodificador {
    List<Pelicula> listaPeliculas;
    List<Pelicula> peliculasReproducidas;
    private tipoSugerencia sugeridor;

   public Decodificador(List<Pelicula> listaEmpresa) {
       this.listaPeliculas = listaEmpresa;
       this.peliculasReproducidas = new ArrayList<>();
   }

   public List<Pelicula> sugerir() {
       return this.sugeridor.sugerir(this);
   }

   public void cambiarTipoSugerencia(tipoSugerencia sugerenciaNueva) {
       this.sugeridor = sugerenciaNueva;
   }


    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public List<Pelicula> getPeliculasReproducidas() {
        return peliculasReproducidas;
    }

    public Pelicula getPeliculaReproducidaRandom() {
        Random random = new Random();
        int limiteMax = peliculasReproducidas.size();

        if (limiteMax > 0) // significa que no esta vacio
        {   int indiceRandom = random.nextInt(limiteMax);
            return peliculasReproducidas.get(indiceRandom);
        } else {
            System.out.println("La lista de peliculas reproducidas esta vacia...");
            return null;
        }

    }
}
