package com.example.Ejercicio_4_5_6.Controllers;

import com.example.Ejercicio_4_5_6.Entities.Laptop;
import com.example.Ejercicio_4_5_6.Repositories.LaptopRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor//inicializa el objeto repository
public class LaptopController {

    private LaptopRepository repositorio;
    private final Logger log= LoggerFactory.getLogger(LaptopController.class);
    //@GetMapping(value={"api/Laptops","api/laptops"})
    @GetMapping(value = {"api/Laptops","api/Laptops/"})
    public List<Laptop> findAll(){
        return repositorio.findAll();
    }

    @GetMapping("api/Laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> aux=repositorio.findById(id);
        return aux.isPresent() ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/api/Laptops/")
    public ResponseEntity<Laptop> create(@RequestBody Laptop lap){

        if (lap.getId() == null) {
            repositorio.save(lap);
            return ResponseEntity.ok().build();
        } else {
            log.warn("Creating object with a ID diferent that null");
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/api/Laptop/update")
    public ResponseEntity<Laptop> update(@RequestBody Laptop lap){

        if(repositorio.existsById(lap.getId())){
            repositorio.save(lap);
            return ResponseEntity.ok().build();
        }else {
            log.warn("Updating object not found by ID");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/Laptop/delete/{id}")
    public ResponseEntity<Laptop> deleteById(@PathVariable Long id){
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            log.warn("Deleting object does not exist");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/apí/Laptop/deleteAll")
    public ResponseEntity<Laptop> deleteAll(){

        if(repositorio.count()>0){
            repositorio.deleteAll();
            log.warn("Deleting all entries in repository");
            return ResponseEntity.notFound().build();
        }
        log.warn("No entries where found");
        return ResponseEntity.noContent().build();
    }

}
