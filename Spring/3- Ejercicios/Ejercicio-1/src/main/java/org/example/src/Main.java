package org.example.src;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

    ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
    Saludo holas= (Saludo)context.getBean("saludo");
    holas.imprimirSaludo();

    }
}