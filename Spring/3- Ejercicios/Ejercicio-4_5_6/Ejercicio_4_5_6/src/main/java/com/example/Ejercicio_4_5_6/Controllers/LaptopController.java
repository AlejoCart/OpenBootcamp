package com.example.Ejercicio_4_5_6.Controllers;

import com.example.Ejercicio_4_5_6.Entities.Laptop;
import com.example.Ejercicio_4_5_6.Repositories.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor//inicializa el objeto repository
public class LaptopController {

    private LaptopRepository repositorio;
    //@GetMapping(value={"api/Laptops","api/laptops"})
    @GetMapping(value = {"api/Laptops","api/Laptops/"})
    public List<Laptop> findAll(){
        return repositorio.findAll();
    }

    @PostMapping("/api/Laptops/")
    public Laptop create(@RequestBody Laptop lap){
        return repositorio.save(lap);
    }

}
