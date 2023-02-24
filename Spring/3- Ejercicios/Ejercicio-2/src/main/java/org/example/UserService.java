package org.example;

import org.springframework.stereotype.Component;

@Component("usuario")
public class UserService {
    public NotificationService aviso= new NotificationService();

    public UserService() {
    }
}
