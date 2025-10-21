package org.example;

import java.util.List;

public class PrendaCombinada implements TipoPrenda{
    private List<TipoBien> prendas;
    private double coeficiente_combinado = 0.5;

    public PrendaCombinada(List<TipoBien> prendas, double coeficiente_combinado) {
        this.prendas = prendas;
        this.coeficiente_combinado = coeficiente_combinado;
    }

    public double getValorTotal() {
        double total =  this.prendas.stream()
                .mapToDouble(TipoBien::getValor)
                .sum();

        return (total * coeficiente_combinado);
    }

}
