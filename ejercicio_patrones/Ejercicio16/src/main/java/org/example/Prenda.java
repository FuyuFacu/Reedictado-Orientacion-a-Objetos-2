package org.example;

public class Prenda implements TipoPrenda {
    private TipoBien prendaSimple;

    public double getValorTotal() {
        return prendaSimple.getValorPrendario();
    }

}
