package org.example;

import java.time.LocalDate;

public class Reserva {
    private int cantidadDias;
    private LocalDate fecha;
    private Usuario conductor;
    private AutoEnAlquiler auto;

    public double montoAReembolsar() {
        // El monto a pagar por una reserva se
        // calcula como el precio por día del auto del cual se hizo la reserva
        // , multiplicado por la cantidad de días.
        return auto.retornarMontoAReembolsar(cantidadDias, fecha);
    }
}

