package com.parkingbooking.parkingbookingv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parkingbooking.parkingbookingv1.services.UserCreationService;

@SpringBootApplication
public class Parkingbookingv1Application implements CommandLineRunner {

	@Autowired
	UserCreationService userCreationService;

	public static void main(String[] args) {
		SpringApplication.run(Parkingbookingv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create initial users
		userCreationService.createUsers();
	}

}
