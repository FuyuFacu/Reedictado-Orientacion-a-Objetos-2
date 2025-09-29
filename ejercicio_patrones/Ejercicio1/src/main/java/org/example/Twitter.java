package org.example;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    List<Usuario> usuariosSistema;

    public Twitter() {
        this.usuariosSistema = new ArrayList<>();
    }

    public void agregarUsuario(Usuario u) {
        if (!usuariosSistema.contains(u)) { // osea si no se encuentra ya en el sistema el usuario
            usuariosSistema.add(u);
        } else System.out.println("El usuario ya se encuentra dentro del sistema");
    }

    public void eliminarUsuario(Usuario u) {
        if (usuariosSistema.contains(u)) {
            u.eliminarTweets();
            usuariosSistema.remove(u);
        } else System.out.println("El usuario a eliminar no se ha encontrado");
    }
}
