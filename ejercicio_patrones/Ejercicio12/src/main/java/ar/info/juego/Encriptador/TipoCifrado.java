package ar.info.juego.Encriptador;

public interface TipoCifrado {

    public String encriptar(String mensaje, String key);
    public String desencriptar(String mensaje, String key);


}
