package org.example;

public class EmpleadoTemporario extends TipoEmpleadoMayor {
    private int cantHorasTrabajadas;

    public EmpleadoTemporario(int cantHijos, boolean estaCasado, int cantHorasTrabajadas) {
        super(cantHijos, estaCasado);
        this.cantHorasTrabajadas = cantHorasTrabajadas;
    }

    public double basico() {
        return 20000 + cantHorasTrabajadas * 300;
    }

    public double adicional() {
        return getAdicionalPorCasado() + getAdicionalPorHijos();
    }

}
