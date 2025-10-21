package org.example;

public class Usuario {
    private String email;
    private String nombre;
    private String apellido;

    public Usuario(String email, String nombre, String apellido) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public void inscribirse(Excursion e) {
        e.agregarUsuario(this);
    }


    public String getEmail() {
        return email;
    }
}
