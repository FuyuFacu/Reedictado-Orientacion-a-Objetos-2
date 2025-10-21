package org.example;
import java.util.List;

public class TopografiaMixta implements ITopografia {
    private List<ITopografia> topografias;

    public TopografiaMixta(List<ITopografia> topografias) {
        this.topografias = topografias;
    }

    public double getProporcion() {
        return this.topografias
                .stream()
                .mapToDouble(ITopografia::getProporcion)
                .sum() / 4; // suma todas las proporciones y las divide por 4 como dice el enunciado.
    }

    public boolean compararTopografias(ITopografia topografia) {
        return this.topografias.equals(topografia);
    }
}
