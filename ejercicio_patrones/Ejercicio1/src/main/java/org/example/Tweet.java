package org.example;

public class Tweet implements TipoTweet {
    private String mensaje;

    public Tweet() {}

    public boolean setTweet(String mensaje) {
        if (cumpleMensaje(mensaje)) {
            this.mensaje = mensaje;
            return true;
        } else return false;
    }

    public boolean cumpleMensaje(String mensaje) {
        return (mensaje.length() < 280 && mensaje.length() > 1);
    }

    public TipoTweet getOrigen() {
        return this;
    }

    public void retweet(TipoTweet tweet) {
        System.out.println("Esto es un tweet, por lo tanto no es un retweet");
    }

    public void leer() {
        System.out.println("Tweet: " + this.mensaje);
    }
}
