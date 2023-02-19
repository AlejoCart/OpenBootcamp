package org.example;

public class gestorFacturas {

    calculatorService calculadora= new calculatorService();

    public gestorFacturas(calculatorService calculadora){
        System.out.println("Ejecutando constructor gestorFacturas");
        this.calculadora= calculadora;

    }
}
