package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private double costo;
    private int cupoMinimo;
    private int cupoMaximo;
    private Estado estadoExcursion;
    private List<Usuario> listaInscriptos;
    private List<Usuario> listaEspera;

    // La aplicación ofrece las excursiones,
    // pero estas solo se realizan si alcanzan el cupo mínimo de inscriptos.


    public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro,
                     double costo, int cupoMinimo, int cupoMaximo, Estado estadoExcursion) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puntoEncuentro = puntoEncuentro;
        this.costo = costo;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
        this.estadoExcursion = estadoExcursion;

        this.listaInscriptos = new ArrayList<>();
        this.listaEspera = new ArrayList<>();
    }

    public String infoBase() {
        return this.nombre + "\n"
                + this.costo + "\n"
                + this.puntoEncuentro + "\n";
    }

    public String getEmailsInscriptos() {
        return this.listaInscriptos.stream()
                .map(Usuario::getEmail)
                .collect(Collectors.joining("\n"));
    }

    public String getCantUsuariosFaltantesCupoMinimo() {
        return "Cantidad usuarios faltantes para alcanzar cupo minimo: "
                + (cupoMinimo - listaInscriptos.size());
    }

    public String getCantUsuariosFaltantesCupoMaximo() {
        return "Cantidad usuarios faltantes para alcanzar cupo maximo: "
                + (cupoMaximo - listaInscriptos.size());
    }

    public String mostrarInformacion() {
        return this.estadoExcursion.display(this);
    }

    public void agregarUsuario(Usuario u) {
        estadoExcursion.agregar(u ,this);
    }

    public void agregarInscriptos(Usuario u) {
        this.listaInscriptos.add(u);
    }

    public void agregarEspera(Usuario u) {
        this.listaEspera.add(u);
    }

    public boolean cupoMinimoAlcanzado() {
        return this.listaInscriptos.size() >= cupoMinimo;
    }

    public boolean cupoMaximoAlcanzado() {
        return this.listaInscriptos.size() >= cupoMaximo;
    }

    public void setEstadoExcursion(Estado estadoExcursion) {
        this.estadoExcursion = estadoExcursion;
    }


}
