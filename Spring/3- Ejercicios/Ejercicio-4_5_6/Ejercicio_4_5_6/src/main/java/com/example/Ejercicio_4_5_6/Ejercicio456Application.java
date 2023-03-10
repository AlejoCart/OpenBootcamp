package com.example.Ejercicio_4_5_6;

import com.example.Ejercicio_4_5_6.Entities.Laptop;
import com.example.Ejercicio_4_5_6.Repositories.LaptopRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Ejercicio456Application {

	public static void main(String[] args) {

		ApplicationContext  context=  SpringApplication.run(Ejercicio456Application.class, args);
		//ApplicationContext contexto=SpringApplication.run(ObRestDataJpaApplication.class, args);
		LaptopRepository laptopRepo= context.getBean(LaptopRepository.class);
		laptopRepo.save(new Laptop(null,"Marca generica","1.23 "));
		System.out.println(laptopRepo.findAll());

	}

}
