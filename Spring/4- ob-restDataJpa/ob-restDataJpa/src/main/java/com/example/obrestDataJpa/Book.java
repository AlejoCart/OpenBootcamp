package com.example.obrestDataJpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/*@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor*/
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String autor;
    private Integer pagesNum;
    private double price;
    private boolean available;
    private Integer stock;
    private LocalDate releaseDate;

    public Book(Long id, String title, String autor, Integer pagesNum, double price, boolean available, Integer stock, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.pagesNum = pagesNum;
        this.price = price;
        this.available = available;
        this.stock = stock;
        this.releaseDate = releaseDate;
    }
    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", pagesNum=" + pagesNum +
                ", price=" + price +
                ", available=" + available +
                ", stock=" + stock +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
