package com.example.testClienteh2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    public Cliente(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Cliente(){

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
