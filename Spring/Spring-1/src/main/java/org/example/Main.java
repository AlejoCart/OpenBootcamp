package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        caculatorService calculadora= (caculatorService) context.getBean("caculatorService");
        calculadora.holaMundo();


        caculatorService calculadora2= (caculatorService) context.getBean("caculatorService");
        calculadora2.holaMundo();
    }
}