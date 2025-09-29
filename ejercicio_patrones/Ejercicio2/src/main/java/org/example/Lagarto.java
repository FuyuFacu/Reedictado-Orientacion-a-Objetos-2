package org.example;

public class Lagarto implements Opcion{

    public void pelear(Opcion o) {
        o.lagarto();
    }
    public void piedra() {
        System.out.println("Gana Piedra, aplasta a Lagarto");
    }
    public void papel() {
        System.out.println("Gana Lagarto, se come el papel");
    }
    public void tijeras() {
        System.out.println("Gana tijeras, decapita a Lagarto");
    }
    public void spock() {
        System.out.println("Gana Lagarto");
    }
    public void lagarto() {
        System.out.println("Empate");
    }

}
