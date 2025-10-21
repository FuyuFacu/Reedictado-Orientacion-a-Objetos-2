package org.example;

public class Inmueble extends TipoBien {
    private String direccion;
    private double superficie;

    public Inmueble(double liquidez, double costo, String direccion, double superficie) {
        super(liquidez, costo);
        this.direccion = direccion;
        this.superficie = superficie;
    }


    @Override
    public double getValor() {
        return superficie * this.getCosto(); // no vale la pena aplicar refactoring,
                                    // es una excepcion este caso que utilizo dos variables de la superclase
    }
}
