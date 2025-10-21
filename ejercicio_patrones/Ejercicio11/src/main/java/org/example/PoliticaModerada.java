package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaCancelacion {
    public double retornarValor(int cantidadDias, double precioPorDia, LocalDate fechaInicio) {
        if (LocalDate.now().isBefore(fechaInicio)) {
            double montoTotal = cantidadDias * precioPorDia;
            if (consultaRealizadaUnaSemanaAntes(fechaInicio)) {
                return montoTotal * 0.5;
            } else if (consultaRealizada2DiasAntes(fechaInicio)) {
                return montoTotal;
            }
        }

        return 0;
    }
    public boolean consultaRealizada2DiasAntes(LocalDate fechaInicio) {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio) <= 2;
    }

    public boolean consultaRealizadaUnaSemanaAntes(LocalDate fechaInicio) {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio) <= 7;
    }
}
