package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pending extends TipoEstado{

    public void agregarComentario(String comment) {
        this.setComentario(comment);
    }

    public void in_progress(ToDoItem todo) {
        todo.setEstado(new InProgress());
    }

    public void pause(ToDoItem todo) {
        throw new RuntimeException("Error, no se puede pausar mientras esta pendiente la tarea");
    }

    public void finish(ToDoItem todo) {}

    public Duration tiempoTrabajado(LocalDate comienzo) {
        throw new RuntimeException("Error, todavia no ha comenzado la tarea");
    }
}
