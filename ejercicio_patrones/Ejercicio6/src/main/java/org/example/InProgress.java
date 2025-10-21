package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InProgress extends TipoEstado {


    public void agregarComentario(String comment) {
        this.setComentario(comment);
    }

    public void in_progress(ToDoItem todo) {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pending");
    }

    public void pause(ToDoItem todo) {
       todo.setEstado(new Pause());
    }

    public void finish(ToDoItem todo) {
        todo.setEstado(new Finished());
    }

    public Duration tiempoTrabajado(LocalDate comienzo) {
        return Duration.between(comienzo, LocalDate.now());
    }

}
