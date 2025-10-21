package org.example;

public class TopografiaTierra implements ITopografia {
    public TopografiaTierra() {
        // No se si es correcto hacerlo de esta manera o crear
        // objetos que implementen ITopografia de TopografiaAgua
        // y TopografiaTierra. Por ahora lo vi mas optimizable esto metodo
    }

    public double getProporcion() {
        return 0;
    }

    public boolean compararTopografias(ITopografia topografia) {
        return this.equals(topografia);
    }
}
