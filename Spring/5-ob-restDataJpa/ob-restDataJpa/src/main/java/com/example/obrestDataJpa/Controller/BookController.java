package com.example.obrestDataJpa.Controller;

import com.example.obrestDataJpa.Entities.Book;
import com.example.obrestDataJpa.Repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor//inicializa el objeto repository
public class BookController {


    //private ApplicationContext contexto;
    private BookRepository repositorio;

    private final Logger log= LoggerFactory.getLogger(BookController.class);

    @GetMapping(value ={"/api/Books", "/api/Books/"})
    public List<Book> findAll(){

        return repositorio.findAll();
    }


    @GetMapping("/api/Books/{id}")
    @ApiOperation("Buscar un libro por id")
    public ResponseEntity<Book> findById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        Optional<Book> aux;//=repositorio.getReferenceById(id);
        aux=repositorio.findById(id);

        return aux.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //Opcion 1
        //return aux.isPresent()?aux.get():null;
        //return aux.orElse(null);

        //Opcion 2
    }
    @PostMapping("/api/Books/")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        if(book.getId()!=null){
            log.warn("trying to create a book with id property diferent than null");
            return ResponseEntity.badRequest().build();
        }else
         {
             repositorio.save(book);
             return ResponseEntity.ok(book);
        }
    }
    /*public Book create(@PathVariable Long id,String title,String autor,Integer pagesNum,double price, boolean available,Integer stock){
        repositorio.save(new Book(id,title,autor,pagesNum,price,available,stock));
    }*/

    @PutMapping("/api/Books/update")
    public ResponseEntity<Book> update(@RequestBody Book book){
        /*Optional<Book> bookOpt=repositorio.findAllById(aux.getId());
        if(bookOpt.isPresent()){
            //Book.BookBuilder aux2= aux.toBuilder();
            Book aux2=repositorio.findAllById((Long.valueOf(aux.getId()));
            aux2.setPrice(aux.getPrice());
            aux2.setStock(aux.getStock());
            aux2.setAvailable(aux.getAvailable());
            return (Book) ResponseEntity.ok();
        }
        else return ResponseEntity.notFound().build();*/
        if(book.getId()==null){
            log.warn("No ID has been send in the request");
            return ResponseEntity.badRequest().build();
        }else if(repositorio.existsById(book.getId())){
            Book save = repositorio.save(book);
            return ResponseEntity.ok(save);
        }
        else {
            log.warn("ID doesn't match any existing objects");
            return ResponseEntity.notFound().build();
        }



        }

    @DeleteMapping("api/Book/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){

        if(id==null){
            log.warn("Id not send");
            return ResponseEntity.badRequest().build();
        }
        else if(repositorio.existsById(id)){
            repositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            log.warn("Trying to delete non exiting object");
            return ResponseEntity.notFound().build();
        }
    }

    @ApiIgnore
    @DeleteMapping("/api/Books/")
    public ResponseEntity<Book> deleteAll(){
        if(repositorio.count()>0){
            repositorio.deleteAll();
            return ResponseEntity.noContent().build();
            }
        else return ResponseEntity.noContent().build();
    }

}
