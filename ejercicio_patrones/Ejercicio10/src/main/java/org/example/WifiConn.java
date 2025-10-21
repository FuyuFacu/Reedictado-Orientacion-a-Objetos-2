package org.example;

public class WifiConn implements Connection {
    private String pict;

    public String sendData(String data, int crc) {
        // simular que se envio la data
        return "data enviada: " + data + " crc: " + crc;
    }

    public String pict() {
        return ""; // no termino de entender esta parte, getter pict()? lo menciona asi que voy a consultarlo el viernes.
    }
}
