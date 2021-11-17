package com.earthquake.pattern.design;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(EarthquakeRepository repository) {
//		return args -> {
//			Earthquake earthquake = new Earthquake("example","today","example","example","example","example","example","example");
//			repository.save(earthquake);
//
//		};
//
//	}

}
