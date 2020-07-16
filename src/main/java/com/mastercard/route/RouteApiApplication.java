package com.mastercard.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mastercard.route.service.PopulateGraphService;

@SpringBootApplication
public class RouteApiApplication implements CommandLineRunner {

	@Autowired
	PopulateGraphService service;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RouteApiApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.populateCityGraph();
	}
}
