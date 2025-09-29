package org.example;

public class Piedra implements Opcion {

    public void pelear(Opcion o) {
        o.piedra();
    }
    public void piedra() {
        System.out.println("Empate");
    }
    public void papel() {
        System.out.println("Gana Papel");
    }
    public void tijeras() {
        System.out.println("Gana Piedra");
    }
    public void lagarto() {
        System.out.println("Gana Piedra");
    }
    public void spock() {
        System.out.println("Gana Spock");
    }
}
