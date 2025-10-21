package org.example;

import java.util.ArrayList;
import java.util.List;

public class TopografiaPantano implements ITopografia {

     public TopografiaPantano() {
        // No se si es correcto hacerlo de esta manera o crear
        // objetos que implementen ITopografia de TopografiaAgua
        // y TopografiaTierra. Por ahora lo vi mas optimizable esto metodo
    }

    public double getProporcion() {
         return 0.7 + 0.3;
    }

    public boolean compararTopografias(ITopografia topografia) {
        return this.equals(topografia); // no entendi el tema este de comparar topografias...
    }
}
