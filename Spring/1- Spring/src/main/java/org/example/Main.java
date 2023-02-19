package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        calculatorService calculadora= (calculatorService) context.getBean("calculator");
        System.out.println("calculadora: ");
        calculadora.holaMundo();
        System.out.println("calculadora 2: \n");

        calculatorService calculadora2= (calculatorService) context.getBean("calculator");
        calculadora2.holaMundo();
        System.out.println();


        //Clase 2
        System.out.println("gestorFacturas 1: ");
        gestorFacturas gestor= (gestorFacturas) context.getBean("gestorFacturas");
        gestor.calculadora.holaMundo();
        System.out.println("gestorFacturas 2: ");
        gestorFacturas gestor2= (gestorFacturas) context.getBean("gestorFacturas");
        gestor2.calculadora.holaMundo();
    }
}