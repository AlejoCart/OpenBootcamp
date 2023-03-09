package com.base.app;

import com.base.app.repo.CocheRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication


		public class StandardApplication{

		public static void main(String []args) {
		ApplicationContext contexto= SpringApplication.run(StandardApplication.class, args);
		CocheRepository repositorioCoche= contexto.getBean(CocheRepository.class);

	}

}
