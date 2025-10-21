package org.example;

public class TopografiaNormal implements ITopografia {
    private int proporcion;

    public TopografiaNormal(int proporcion) {
        this.proporcion = proporcion;   // No se si es correcto hacerlo de esta manera o crear
                                        // objetos que implementen ITopografia de TopografiaAgua
                                        // y TopografiaTierra. Por ahora lo vi mas optimizable esto metodo
    }

    public double getProporcion() {
        return proporcion;
    }

    public boolean compararTopografias(ITopografia topografia) {
        return this.equals(topografia);
    }
}
