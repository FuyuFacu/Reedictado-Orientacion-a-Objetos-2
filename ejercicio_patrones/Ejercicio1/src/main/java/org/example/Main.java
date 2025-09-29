package org.example;

import java.util.Scanner;

public class Main {
    public static String generarMensaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un mensaje:");
        String mensaje = scanner.nextLine();
        scanner.close();

        return mensaje;

    }
    static void main() {
        Usuario usuario = new Usuario("Pedro");
        String mensaje = generarMensaje();
        usuario.postear(mensaje);

        TipoTweet tweet = new Tweet();
        boolean postCompletado = tweet.setTweet("Testeando a ver si funciona");
        if (postCompletado)
            usuario.retweet(tweet);

        usuario.leerTodo();

    }
}
