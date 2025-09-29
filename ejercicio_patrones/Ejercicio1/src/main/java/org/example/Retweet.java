package org.example;

public class Retweet implements TipoTweet {
    TipoTweet origen;

    public boolean setTweet(String mensaje) {
        System.out.println("No se puede, es un retweet");
        return false;
    }

    public void retweet(TipoTweet tweet) {
        this.origen = tweet;
    }

    public TipoTweet getOrigen() {
        return origen;
    }

    public void leer() {
        System.out.print("*Retweet* -> ");
        origen.leer();
    }
}
