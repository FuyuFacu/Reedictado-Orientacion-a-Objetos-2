package org.example;

public abstract class TipoBien {
    private double Liquidez;
    private double costo;

    public TipoBien(double liquidez, double costo) {
        Liquidez = liquidez;
        this.costo = costo;
    }

    public double getLiquidez() {
        return Liquidez;
    }

    public double getCosto() {
        return costo;
    }
    public double getValorPrendario() {
        return this.getValor() * this.getLiquidez();
    }

    public abstract double getValor();
}
