package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pause extends TipoEstado {

    public void agregarComentario(String comment) {
        this.setComentario(comment);
    }

    public void in_progress(ToDoItem todo) {} // No hace nada segun el enunciado

    public void pause(ToDoItem todo) {
        todo.setEstado(new InProgress());
    }

    public void finish(ToDoItem todo) {
        todo.setEstado(new Finished());
    }

    public Duration tiempoTrabajado(LocalDate comienzo) {
        return Duration.between(comienzo, LocalDate.now());
    }
}
