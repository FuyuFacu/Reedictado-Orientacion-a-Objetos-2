package org.example;

import java.time.Duration;
import java.time.LocalDate;

public class Finished extends TipoEstado {

    public void agregarComentario(String comment) {}

    public void in_progress(ToDoItem todo) {}

    public void pause(ToDoItem todo) {
        throw new RuntimeException("Error, no se puede pausar una vez que haya sido finalizado el task");
    }

    public void finish(ToDoItem todo) {}

    public Duration tiempoTrabajado(LocalDate comienzo) {
        return Duration.between(comienzo, LocalDate.now());
    }
}
