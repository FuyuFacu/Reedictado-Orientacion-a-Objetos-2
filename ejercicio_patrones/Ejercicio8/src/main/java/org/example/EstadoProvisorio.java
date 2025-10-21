package org.example;

public class EstadoProvisorio extends Estado {

    public String display(Excursion e) {
        return e.infoBase() + e.getCantUsuariosFaltantesCupoMinimo();
    }
    public void agregar(Usuario u, Excursion e) {
        if (e.cupoMinimoAlcanzado()) e.setEstadoExcursion(new EstadoDefinitivo());
        else e.agregarInscriptos(u);
    }

}
