package com.example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext contexto= SpringApplication.run(TestApplication.class, args);
		CocheRepository repositorio=contexto.getBean(CocheRepository.class);
		ClienteRepository repotorio2=contexto.getBean(ClienteRepository.class);

		System.out.println("Numero de coches: "+repositorio.count());
		System.out.println("Agregando coche");
		Coche aux=Coche.builder().build();
		aux.setName("Toyota corolla");
		repositorio.save(aux);

		System.out.println("Lista de coches: "+repositorio.findAll());


		System.out.println("Numero de Clientes: "+repotorio2.count());
		System.out.println("Agregando cliente");

		Cliente auxCl= Cliente.builder().name("aaa .h").build();
		repotorio2.save(auxCl);
		System.out.println("Lista de clientes"+repotorio2.findAll());




	}

}
