package com.ncuello.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MutantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
	}

}
