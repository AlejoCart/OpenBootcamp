package com.example.Ejercicio_4_5_6.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("api/Saludo")
    public String Saludo(){
        return "Hola Mundo, que tal todo? ";
    }

}
