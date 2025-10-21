package org.example;

import java.time.LocalDate;
import java.util.List;

public class Archivo extends TipoArchivo {

    public Archivo(int tamano, LocalDate fecha, String nombre) {
        super(tamano, fecha, nombre);
    }

    @Override
    public int getTamanoTotal() {
        return this.getTamano();
    }

    @Override
    public TipoArchivo getArchivoMasGrande() {
        return this;
    }

    @Override
    public TipoArchivo getArchivoMasNuevo() {
        return this;
    }

    @Override
    public TipoArchivo buscarPrimerArchivo(String nombre) {
        if (this.esArchivoBuscado(nombre)) return this;
        else return new ArchivoNulo();
    }

    @Override
    public List<TipoArchivo> getArchivosQueCumplan(String nombre) {
        if (this.esArchivoBuscado(nombre)) return List.of(this);
        else return List.of();
    }

    @Override
    public String imprimir() {
        return this.getNombre() + "/" + "\n";
    }
}
