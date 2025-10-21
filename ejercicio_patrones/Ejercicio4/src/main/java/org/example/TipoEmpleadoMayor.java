package org.example;

public abstract class TipoEmpleadoMayor extends TipoEmpleado{
    private int cantHijos;
    private boolean estaCasado;

    public TipoEmpleadoMayor(int cantHijos, boolean estaCasado) {
        this.cantHijos = cantHijos;
        this.estaCasado = estaCasado;
    }

    public int getAdicionalPorHijos() {
        if (cantHijos == 0) return 0;
        else return cantHijos * 2000;
    }

    public double getAdicionalPorCasado() {
        if (estaCasado) return 5000;
        else return 0;
    }

    public abstract double basico();
    public abstract double adicional();

}
