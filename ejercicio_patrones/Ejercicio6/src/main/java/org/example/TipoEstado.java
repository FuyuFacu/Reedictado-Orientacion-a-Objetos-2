package org.example;

import java.time.Duration;
import java.time.LocalDate;

public abstract class TipoEstado {
    private String comentario;


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public abstract void agregarComentario(String comment);
    public abstract void in_progress(ToDoItem todo);
    public abstract void pause(ToDoItem todo);
    public abstract void finish(ToDoItem todo);
    public abstract Duration tiempoTrabajado(LocalDate comienzo);

}
