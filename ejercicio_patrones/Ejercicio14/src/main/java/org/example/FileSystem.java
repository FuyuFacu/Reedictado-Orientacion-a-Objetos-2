package org.example;

import java.util.List;

public class FileSystem {
    private TipoArchivo directorioRaiz;

    public FileSystem(TipoArchivo directorioRaiz) {
        this.directorioRaiz = directorioRaiz;
    }

    /**
     * Retorna el espacio total ocupado, incluyendo todo su contenido.
     */
    public int tamanoTotalOcupado() {
        return directorioRaiz.getTamanoTotal();
    }

    /**
     * Retorna el archivo con mayor cantidad de bytes en cualquier nivel del
     * filesystem.
     */
    public TipoArchivo archivoMasGrande() {
       return directorioRaiz.getArchivoMasGrande();
    }

    public TipoArchivo archivoMasNuevo() {
        return directorioRaiz.getArchivoMasNuevo();
    }

    public TipoArchivo buscar(String nombre) {
        return directorioRaiz.buscarPrimerArchivo(nombre);
    }

    public List<TipoArchivo> buscarTodos(String nombre) {
       return this.directorioRaiz.getArchivosQueCumplan(nombre);
    }

    public String listadoDeContenido() {
        return this.directorioRaiz.imprimir();
    }





}
