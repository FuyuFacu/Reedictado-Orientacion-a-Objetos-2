package org.example;

public class EstadoError implements IEstado {

    public void SetValor(Calculadora context, double valor) {
    }


    public void mas(Calculadora context) {
        context.setEstado(new EstadoSuma());
    }

    public void menos(Calculadora context) {
        context.setEstado(new EstadoResta());
    }

    public void division(Calculadora context) {
        context.setEstado(new EstadoDivision());
    }

    public void multiplicacion(Calculadora context) {
        context.setEstado(new EstadoMultiplicacion());
    }

    public void borrar(Calculadora context) {
        context.setEstado(new EstadoBorrado());
    }
}
