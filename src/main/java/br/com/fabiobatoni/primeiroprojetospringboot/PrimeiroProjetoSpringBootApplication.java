package br.com.fabiobatoni.primeiroprojetospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.fabiobatoni")
public class PrimeiroProjetoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringBootApplication.class, args);
	}

}
