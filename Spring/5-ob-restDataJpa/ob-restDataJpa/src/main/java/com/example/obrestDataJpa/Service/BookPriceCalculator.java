package com.example.obrestDataJpa.Service;

import com.example.obrestDataJpa.Entities.Book;

public class BookPriceCalculator {



    public double calculate(Book libro){
        double price=libro.getPrice();

        if(libro.getPagesNum()>300)
            price+=5;

        price+=2.99;
        return price;
    }

}
