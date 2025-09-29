package org.example;

public class Tijera implements Opcion{

    public void pelear(Opcion o) {
        o.tijeras();
    }
    public void piedra() {
        System.out.println("Gana Piedra");
    }
    public void papel() {
        System.out.println("Gana Tijeras!!");
    }
    public void tijeras() {
        System.out.println("Empate");
    }
    public void lagarto() {
        System.out.println("Gana Tijeras!!");
    }
    public void spock() {
        System.out.println("Gana Spock, rompe tijeras");
    }
}
