package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    List<TipoTweet> tweets;

    public Usuario(String screenName) {
        this.screenName = screenName;
        tweets = new ArrayList<>();
    }

    public void postear(String mensaje) { // de hasta 280 caracteres
        TipoTweet nuevoTweet = new Tweet();
        boolean completado = nuevoTweet.setTweet(mensaje);

        if (completado) {
            System.out.println("Posteo realizado exitosamente");
            tweets.add(nuevoTweet);
        } else System.out.println("No se pudo crear el tweet (cantidad de caracteres >= 280 o < 1");

    }

    public void retweet(TipoTweet tweet) {
        TipoTweet origen = tweet.getOrigen();

        TipoTweet ret = new Retweet();
        ret.retweet(origen);
        tweets.add(ret);
    }

    public void eliminarTweets() {
        this.tweets.clear();
    }

    public void leerMensajes(TipoTweet tweet) { // de hasta 280 caracteres
        tweet.leer();
    }

    public String getScreenName() {
        return screenName;
    }

    public boolean cumpleMensaje(String mensaje) {
        return (mensaje.length() < 280 && mensaje.length() > 1);
    }

    public void leerTodo() {
        System.out.println("Imprimiendo todos los tweets...");
        tweets.forEach(TipoTweet::leer);
    }
}
