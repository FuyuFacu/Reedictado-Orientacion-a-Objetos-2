package org.example;

import java.time.LocalDate;

public class PoliticaFlexible implements PoliticaCancelacion {
    public double retornarValor(int cantidadDias, double precioPorDia, LocalDate fechaReserva) {
        if (LocalDate.now().isBefore(fechaReserva)) {
            return cantidadDias * precioPorDia;
        } else return 0;
    }
}
