package org.example;

// Esto seria un template method
public abstract class TipoEmpleado {

    public double sueldo() {
        return this.basico() + this.adicional() + this.descuento();
    }

    public double descuento() {
        return this.basico() * 0.13 + this.adicional() * 0.05;
    }

    public abstract double basico();
    public abstract double adicional();
}
