package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Opcion o = new Tijera();
        Opcion o2 = new Piedra();

        Jugador j1 = new Jugador(o);
        Jugador j2 = new Jugador(o2);

        j1.decidirGanador(j2);

        // Acá testeo a recibir otro output, a ver si funciona correctamente
        // (utilizo las variables ya declaradas anteriormente)

        o = new Papel();
        o2 = new Piedra();

        j1 = new Jugador(o);
        j2 = new Jugador(o2);

        j1.decidirGanador(j2);

        // Ahora testeo a recibir output "Empate"
        o2 = new Papel();
        j2 = new Jugador(o2);
        j1.decidirGanador(j2);

        // Ahora testeo con las nuevas opciones agregadas:
        o2 = new Spock();
        o = new Lagarto();

        j1 = new Jugador(o);
        j2 = new Jugador(o2);

        j1.decidirGanador(j2);


    }
}
