package org.example;

public class CuatroGConnection implements Connection {

    public String sendData(String data, int crc) {
        return "Data en 4G: " + data + " crc: " + crc;
    }
    public String pict() {
        return "pict nose xd";
    }
}
