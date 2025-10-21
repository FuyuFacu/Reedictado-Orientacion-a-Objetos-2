package org.example;

import java.time.LocalDate;
import java.util.List;

public class Pelicula {
    private String titulo;
    private LocalDate fechaEstreno;
    private int puntaje;

    // La similaridad establece una relación recíproca entre dos películas,
    // por lo que si A es similar a B entonces también B es similar a A.
    private List<Pelicula> peliculasSimilares;

    public Pelicula() {}

    public Pelicula(String titulo, LocalDate fechaEstreno, int puntaje, List<Pelicula> peliculasSimilares) {
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.puntaje = puntaje;
        this.peliculasSimilares = peliculasSimilares;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public List<Pelicula> getPeliculasSimilares() {
        return peliculasSimilares;
    }

    public boolean contienePeliculaSimilar(Pelicula p) {
        return this.peliculasSimilares.contains(p);
    }

    public int getPuntaje() {
        return puntaje;
    }
}
