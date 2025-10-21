package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends TipoBien {
    private LocalDate comienzoContrato;
    private LocalDate finContrato;

    public Alquiler(double liquidez, double costo, LocalDate comienzoContrato, LocalDate finContrato) {
        super(liquidez, costo);
        this.comienzoContrato = comienzoContrato;
        this.finContrato = finContrato;
    }

    @Override
    public double getValor() {
        long cantMeses = ChronoUnit.MONTHS.between(LocalDate.now(), finContrato); // supongo que se refiere
                                                            // meses que faltan para que se acabe el contrato

        return (cantMeses * this.getCosto());
    }
}
