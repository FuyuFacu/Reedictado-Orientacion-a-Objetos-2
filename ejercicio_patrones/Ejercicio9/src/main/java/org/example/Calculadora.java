package org.example;

public class Calculadora {
    private double valorAcumulado;
    private double valorActual;
    private IEstado estado;


    /**
     * Devuelve el resultado actual de la operación realizada.
     * Si no se ha realizado ninguna operación, devuelve el valor acumulado.
     * Si la calculadora se encuentra en error, devuelve “error”
     */
    public String getResultado() {
        return "Resultado: " + resultado;
    }


    /**
     * Pone en cero el valor acumulado y reinicia la calculadora
     */
    public void borrar() {
        valorAcumulado = 0;
        this.estado = new EstadoInicial();
    }

    public void setValorActual(double valor) {
        this.valorActual = valor;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }


    /**
     * Asigna un valor para operar.
     * si hay una operación en curso, el valor será utilizado en la operación
     */
    public void setValor(double unValor) {
        this.valorAcumulado = estado.operar(unValor, valorAcumulado);
    }


    /**
     * Indica que la calculadora debe esperar un nuevo valor.
     * Si a continuación se le envía el mensaje setValor(), la calculadora sumará
     * el valor recibido como parámetro, al valor actual y guardará el resultado
     */
    public void mas() {



    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }


    public double getValorActual() {
        return valorActual;
    }
}
