package com.example.obrestDataJpa.Controller;

import com.example.obrestDataJpa.Entities.Book;
import com.example.obrestDataJpa.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class BookController {


    //private ApplicationContext contexto;
    private BookRepository repositorio;

    @GetMapping(value ={"/api/Books", "/api/Books/"})
    public List<Book> findAll(){

        return repositorio.findAll();
    }


    @GetMapping("/api/Books/{id}")
    public /*Book*/ ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> aux;//=repositorio.getReferenceById(id);
        aux=repositorio.findById(id);

        return aux.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //Opcion 1
        //return aux.isPresent()?aux.get():null;
        //return aux.orElse(null);

        //Opcion 2


    }

    @PostMapping("/api/Books/")
    public Book create(@RequestBody Book book){
        return repositorio.save(book);
    }
    /*public Book create(@PathVariable Long id,String title,String autor,Integer pagesNum,double price, boolean available,Integer stock){
        repositorio.save(new Book(id,title,autor,pagesNum,price,available,stock));
    }*/



}
