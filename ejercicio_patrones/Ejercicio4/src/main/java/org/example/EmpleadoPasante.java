package org.example;

public class EmpleadoPasante extends TipoEmpleado{
    private int cantExamenesRendidos;

    public EmpleadoPasante(int cantExamenesRendidos) {
        this.cantExamenesRendidos = cantExamenesRendidos;
    }

    public double basico() {
        return 20000;
    }

    public double adicional() {
        return cantExamenesRendidos * 2000;
    }

}
