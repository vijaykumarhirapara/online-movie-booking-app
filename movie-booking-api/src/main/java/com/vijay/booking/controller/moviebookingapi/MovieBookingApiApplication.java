package com.vijay.booking.controller.moviebookingapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vijay.booking")
public class MovieBookingApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApiApplication.class, args);
		LOGGER.info("MovieBookingApiApplication started successfully");
	}

}
