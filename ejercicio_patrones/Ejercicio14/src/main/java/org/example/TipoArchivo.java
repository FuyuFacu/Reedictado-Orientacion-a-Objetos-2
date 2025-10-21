package org.example;

import java.time.LocalDate;
import java.util.List;

public abstract class TipoArchivo {
    private int tamano;
    private LocalDate fecha;
    private String nombre;


    public TipoArchivo(int tamano, LocalDate fecha, String nombre) {
        this.tamano = tamano;
        this.fecha = fecha;
        this.nombre = nombre;
    }


    public boolean esArchivoBuscado(String nombre) {
        return this.nombre.equals(nombre);
    }

    public int getTamano() {
        return this.tamano;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String imprimir();
    public abstract int getTamanoTotal();
    public abstract TipoArchivo getArchivoMasGrande();
    public abstract TipoArchivo getArchivoMasNuevo();
    public abstract TipoArchivo buscarPrimerArchivo(String nombre);
    public abstract List<TipoArchivo> getArchivosQueCumplan(String nombre);


}
