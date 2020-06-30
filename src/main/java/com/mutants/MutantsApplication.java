package com.mutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MutantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantsApplication.class, args);
	}

}
