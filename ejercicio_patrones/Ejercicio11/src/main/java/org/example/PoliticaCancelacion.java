package org.example;

import java.time.LocalDate;

public interface PoliticaCancelacion {
    public double retornarValor(int cantidadDias, double precioPorDia,
                                LocalDate fechaReserva);

}
