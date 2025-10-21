package org.example;

public class EstadoMaximo extends Estado {

    public String display(Excursion e) {
        return e.infoBase();
    }
    public void agregar(Usuario u, Excursion e) {
        e.agregarEspera(u);
    }
}
