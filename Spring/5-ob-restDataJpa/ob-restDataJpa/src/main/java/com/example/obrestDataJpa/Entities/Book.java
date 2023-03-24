package com.example.obrestDataJpa.Entities;

import /*jakarta*/javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
//@Builder(toBuilder = true)
@Table(name = "Books")
@ApiModel("Entidad libro para representar un elemento didáctico compuesto por láminas de celulosa macerada en Puerto Rico")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave autoincrementaltipo Long")
    private Long id;
    private String title;
    private String autor;
    private Integer pagesNum;
    private double price;
    private boolean available;
    private Integer stock;
    private LocalDate releaseDate;

    public boolean getAvailable(){
        return this.available;
    }

    /*public Book(){

    }*/
}
