package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        UserService servicio=(UserService) context.getBean("usuario");
        servicio.aviso.imprimirSaludo();

    }
}