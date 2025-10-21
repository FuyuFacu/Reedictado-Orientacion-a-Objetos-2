package org.example;

public class EstadoDefinitivo extends Estado {

    public String display(Excursion e) {
        return e.infoBase() + e.getEmailsInscriptos() + e.getCantUsuariosFaltantesCupoMaximo();
    }
    public void agregar(Usuario u, Excursion e) {
        if (e.cupoMaximoAlcanzado()) e.setEstadoExcursion(new EstadoMaximo());
        else e.agregarInscriptos(u);
    }
}
