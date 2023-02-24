package org.example;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public String menssage="Holas";
    public NotificationService() {
    }

    public void imprimirSaludo(){
        System.out.println(menssage);
    }
}
