package org.example;

public class Papel implements Opcion {
    public void pelear(Opcion o) {
        o.papel();
    }
    public void piedra() {
        System.out.println("Gana Papel");
    }
    public void papel() {
        System.out.println("Empate");
    }
    public void tijeras() {
        System.out.println("Gana Tijeras");
    }
    public void lagarto() {
        System.out.println("Gana Lagarto");
    }
    public void spock() {
        System.out.println("Gana Papel");
    }
}
