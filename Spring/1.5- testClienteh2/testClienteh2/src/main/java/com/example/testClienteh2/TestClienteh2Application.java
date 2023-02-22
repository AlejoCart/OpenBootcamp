package com.example.testClienteh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestClienteh2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(TestClienteh2Application.class, args);
		ClienteRepository repository= context.getBean(ClienteRepository.class,args);

		repository.save(new Cliente(null,"pepito"));

		System.out.println("Clientes: "+repository.findAll());




	}

}
