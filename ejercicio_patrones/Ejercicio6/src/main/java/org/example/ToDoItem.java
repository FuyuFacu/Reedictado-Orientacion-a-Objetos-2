package org.example;


import java.time.Duration;
import java.time.LocalDate;

public class ToDoItem {
    private String nombre;
    TipoEstado estado;
    private LocalDate comienzoTarea;


    /**
     * Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
     */
    public ToDoItem(String name) {
        this.nombre = nombre;
        estado = new Pending();
    }


    /**
     * Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
     * pending. Si se encuentra en otro estado, no hace nada.
     */
    public void start() {
        this.estado.in_progress(this);
        this.comienzoTarea = LocalDate.now();
    }


    /**
     * Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress
     * si su estado es paused. Caso contrario (pending o finished) genera un
     * error informando la causa específica del mismo.
     */
    public void togglePause() {
        this.estado.pause(this);
    }


    /**
     * Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
     * in-progress o paused. Si se encuentra en otro estado, no hace nada.
     */
    public void finish() {
        this.estado.finish(this);
    }


    /**
     * Retorna el tiempo que transcurrió desde que se inició el ToDoItem
     * (start) hasta que se finalizó. En caso de que no esté finalizado, el
     * tiempo que haya transcurrido hasta el momento actual. Si el ToDoItem no
     * se inició, genera un error informando la causa específica del mismo.
     */
    public Duration workedTime() {
        return this.estado.tiempoTrabajado(comienzoTarea);
    }


    /**
     * Agrega un comentario al ToDoItem siempre y cuando no haya finalizado.
     * Caso contrario no hace nada.
     */
    public void addComment(String comment) {
        this.estado.agregarComentario(comment);
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }
}

