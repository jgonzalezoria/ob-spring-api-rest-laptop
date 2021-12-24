package com.jgonzalezoria.obspringapirestlaptop;

import com.jgonzalezoria.obspringapirestlaptop.entities.Laptop;
import com.jgonzalezoria.obspringapirestlaptop.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringApiRestLaptopApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(ObSpringApiRestLaptopApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD
		// crear un portatil
		Laptop laptop1 = new Laptop(null, "HP", "I7", 32, 1000, true, 1200);
		Laptop laptop2 = new Laptop(null, "TOSHIBA", "I5", 8, 1000, true, 450);

		// almacenar un portatil
		repository.save(laptop1);
		repository.save(laptop2);
	}

}
