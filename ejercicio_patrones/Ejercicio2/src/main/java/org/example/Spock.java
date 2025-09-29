package org.example;

public class Spock implements Opcion{
    public void pelear(Opcion o) {
        o.spock();
    }
    public void piedra() {
        System.out.println("Gana Spock, vaporiza a piedra");
    }
    public void papel() {
        System.out.println("Gana papel, desaprueba a spock");
    }
    public void tijeras() {
        System.out.println("Gana Spock, rompe tijeras");
    }
    public void lagarto() {
        System.out.println("Gana lagarto, envenena a Spock");
    }
    public void spock() {
        System.out.println("Empate");
    }
}
