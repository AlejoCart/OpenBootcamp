package com.example.simpleJPAH2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleJpaH2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SimpleJpaH2Application.class, args);
		//ClienteRepository repository= context.getBean(ClienteRepository.class);
		//CocheRepository repository = context.getBean(CocheRepository.class);

		//System.out.println("Cantidad de clientes"+repository.count());
		//System.out.println("Adding cliente");

		//Cliente aux=new Cliente(null,"Pepito","Por ahi");
		//repository.save(aux);

		//System.out.println("Cantidad de clientes"+repository.count());
		Cliente2Repository repositorio= context.getBean(Cliente2Repository.class);


	}

}
