package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Directorio extends TipoArchivo {
    private List<TipoArchivo> contenidoDirectorio;

    public Directorio(int tamano, LocalDate fecha, String nombre, List<TipoArchivo> contenidoDirectorio) {
        super(tamano, fecha, nombre);
        this.contenidoDirectorio = contenidoDirectorio;
    }

    @Override
    public int getTamanoTotal() {
        return this.getTamano() +
                contenidoDirectorio.stream()
                .mapToInt(TipoArchivo::getTamanoTotal)
                .sum();
    }

    @Override
    public TipoArchivo getArchivoMasGrande() {
        return this.contenidoDirectorio.stream()
                .map(TipoArchivo::getArchivoMasGrande)
                .max(Comparator.comparingLong(TipoArchivo::getTamano))
                .orElse(new ArchivoNulo());
    }

    @Override
    public TipoArchivo getArchivoMasNuevo() {
        return this.contenidoDirectorio
                .stream()
                .map(TipoArchivo::getArchivoMasNuevo)
                .max(Comparator.comparing(TipoArchivo::getFecha))
                .orElse(new ArchivoNulo());
    }

    @Override
    public TipoArchivo buscarPrimerArchivo(String nombre) {
        if (this.esArchivoBuscado(nombre)) {
            return this;
        }

        return this.contenidoDirectorio.stream()
                .map(hijo -> hijo.buscarPrimerArchivo(nombre))
                .filter(Objects::nonNull) // Aca tambien
                .filter(resultado -> !(resultado instanceof ArchivoNulo)) // preguntar si esto es correcto
                                                            // ya que si no es
                                                            // el buscado retorno un archivoNulo
                .findFirst()
                .orElse(new ArchivoNulo());
    }


    @Override
    public List<TipoArchivo> getArchivosQueCumplan(String nombre) {
        // 1. Uso flatMap para obtener una lista plana con los resultados de los hijos.
        List<TipoArchivo> archivosEncontrados = this.contenidoDirectorio.stream()
                // Por cada hijo, obtenemos su lista de resultados y la convertimos en un stream.
                // flatMap se encarga de unir todos esos streams en uno solo, como si fuera un addAll
                .flatMap(hijo -> hijo.getArchivosQueCumplan(nombre).stream())
                .toList();

        if (this.esArchivoBuscado(nombre)) {
            archivosEncontrados.add(this);
        }

        return archivosEncontrados;
    }


    @Override
    public String imprimir() {
        String total = "";
        for (TipoArchivo arch : contenidoDirectorio) {
           total += "/Directorio " + this.getNombre() + "/ " + arch.imprimir();
        }

        return total;
    }
}
