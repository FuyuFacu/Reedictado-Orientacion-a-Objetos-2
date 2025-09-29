package org.example;

public class Jugador {
    Opcion opcion;

    public Jugador(Opcion opcion) {
        this.opcion = opcion;
    }

    public void decidirGanador(Jugador j2) {
        this.opcion.pelear(j2.getOpcion());
    }

    public Opcion getOpcion() {
        return opcion;
    }
}
