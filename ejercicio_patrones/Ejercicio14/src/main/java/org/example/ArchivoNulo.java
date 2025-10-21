package org.example;

import java.time.LocalDate;
import java.util.List;

public class ArchivoNulo extends TipoArchivo {

    public ArchivoNulo() {
        super(1, LocalDate.of(111111,11,11), "");
    }

    @Override
    public int getTamanoTotal() {
        return 0;
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
        return this;
    }

    @Override
    public String imprimir() {
        return "";
    }

    @Override
    public List<TipoArchivo> getArchivosQueCumplan(String nombre) {
        return List.of();
    }
}

