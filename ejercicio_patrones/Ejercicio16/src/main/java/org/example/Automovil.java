package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil extends TipoBien {
    private LocalDate fechaCreacion;
    private String Modelo;
    private double Kilometraje;

    public Automovil(double liquidez, double costo,
                     LocalDate fechaCreacion, String modelo, double kilometraje) {

        super(liquidez, costo);
        this.fechaCreacion = fechaCreacion;
        Modelo = modelo;
        Kilometraje = kilometraje;
    }

    public double getValor() {
        return reducirValorPorAntiguedad();
    }

    public double reducirValorPorAntiguedad() {
        double aux = this.getCosto();
        long antiguedadEnAnios = ChronoUnit.YEARS.between(fechaCreacion, LocalDate.now());

        for (int i = 1; i <= antiguedadEnAnios; i++) {
            aux *= 0.90;
            // consigo el porcentaje actual del valor y
            // lo reduzco "antiguedadEnAnios" veces
        }

        return aux;
    }





}
