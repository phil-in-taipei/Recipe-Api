package com.example.RecipeApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Profile("test")
public class RecipeApiApplication {

	//@Autowired
	//private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(RecipeApiApplication.class, args);
	}

}
