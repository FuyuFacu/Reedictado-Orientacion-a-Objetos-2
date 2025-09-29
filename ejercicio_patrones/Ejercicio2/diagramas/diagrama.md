
class Jugador {
    +jugador(opcion: Opcion): void;
    +decidirGanador(j2: Jugador): void;
    +getOpcion(): Opcion;
}

interface Opcion {
    +pelear(o: Opcion): void;
    +piedra(): void;
    +papel(): void;
    +tijeras(): void;
    +lagarto(): void;
    +spock(): void;
}

class Papel implements Opcion {}
class Tijera implements Opcion {}
class Piedra implements Opcion {}
class Lagarto implements Opcion {}
class Spock implements Opcion {}

Jugador --> Opcion : 1



