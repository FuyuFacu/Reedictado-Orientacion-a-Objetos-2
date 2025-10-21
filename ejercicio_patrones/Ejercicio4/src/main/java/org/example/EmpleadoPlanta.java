package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoPlanta extends TipoEmpleadoMayor {
    private LocalDate fechaInicio;


    public EmpleadoPlanta(int cantHijos, boolean estaCasado, LocalDate fechaInicio) {
        super(cantHijos, estaCasado);
        this.fechaInicio = fechaInicio;
    }

    public double basico() {
        return 50000;
    }

    public double getAdicionalPorAntiguedad() {
        return ChronoUnit.YEARS.between(fechaInicio, LocalDate.now()) * 2000;
    }

    public double adicional() {
        return getAdicionalPorCasado() + getAdicionalPorHijos() + getAdicionalPorAntiguedad();
    }
}
