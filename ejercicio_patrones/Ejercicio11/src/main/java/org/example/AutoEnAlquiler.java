package org.example;

import java.time.LocalDate;

public class AutoEnAlquiler {
    private double precioPorDia;
    private int cantidadPlazas;
    private String marca;
    private PoliticaCancelacion politicaCancelacion;

    public double retornarMontoAReembolsar(int cantidadDias, LocalDate fechaReserva) {
        return politicaCancelacion.retornarValor(cantidadDias, precioPorDia, fechaReserva);
    }

    public void setPoliticaDeCancelacion(PoliticaCancelacion politica) {
        this.politicaCancelacion = politica;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }
}
