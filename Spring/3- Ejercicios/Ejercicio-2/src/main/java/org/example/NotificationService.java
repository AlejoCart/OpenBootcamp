package org.example;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public String menssage="Notificacion";
    public NotificationService() {
    }

    public void imprimirSaludo(){
        System.out.println(menssage);
    }
}
