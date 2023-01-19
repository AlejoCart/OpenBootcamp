package org.AlejoCart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        calculatorService calculadora= (calculatorService) context.getBean("caculatorService");
        System.out.println(calculadora.holaMundo());


    }
}