/*package com.example.OB1.Controller;

import com.example.OB1.Models.bootCamper;
import com.example.OB1.Repository.bootCamperRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class bootCamperController2 {

    private bootCamperRepository repositorio;


    @GetMapping(value ={"/api/bootCampers","/api/bootCampers/"})
    public List<bootCamper> findAll(){
        if (repositorio.count()>0) return repositorio.findAll();
        else return null;
    }

    @GetMapping("/api/bootCamper/{id}")
    public ResponseEntity<bootCamper> findById(@PathVariable Long id){
        Optional<bootCamper> aux=repositorio.findById(id);
        return aux.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
*/