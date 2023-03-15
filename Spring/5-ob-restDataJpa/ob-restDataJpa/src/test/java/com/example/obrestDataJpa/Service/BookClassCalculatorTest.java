package com.example.obrestDataJpa.Service;

import com.example.obrestDataJpa.Entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookClassCalculatorTest {

    @Test
    void calculate() {
        //Config de la prueba
        BookPriceCalculator calulcator=new BookPriceCalculator();
        Book aux=new Book(null,
                "titulo generico",
                "Autor generico",
                500,
                31.99,
                true,
                500,
                LocalDate.of(2005,12,24));

        //Ejecucion de la prueba
        double price=calulcator. calculate(aux);
        System.out.println(price);
        //Comprobaciones de los resultados

        assertTrue(price>0);

        /*if(aux.getPagesNum()>300){
            assertTrue(price-aux.getPrice()>5);
        }*/



    }
}