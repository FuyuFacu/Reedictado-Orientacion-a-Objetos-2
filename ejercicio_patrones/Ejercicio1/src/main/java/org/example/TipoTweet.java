package org.example;

public interface TipoTweet {

    public boolean setTweet(String mensaje);
    public void retweet(TipoTweet tweet);
    public void leer();
    public TipoTweet getOrigen();
}
