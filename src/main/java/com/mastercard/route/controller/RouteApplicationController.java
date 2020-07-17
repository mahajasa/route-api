package com.mastercard.route.controller;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.route.service.RouteService;


@RestController
@RequestMapping("/api/routes")
public class RouteApplicationController {

	@Autowired
	RouteService service;
	
	Logger logger = LoggerFactory.getLogger(RouteApplicationController.class);
	
	@GetMapping("/info")
	public ResponseEntity<String> ping(){
		logger.info("Healthcheck invoked");
		return ResponseEntity.ok("Service running");
	}

	@GetMapping("/connected")
	public ResponseEntity<String> doesRouteExist(@RequestParam String sourceCity, @RequestParam String destinationCity) {
		logger.info("doesRouteExist entered : source" + sourceCity + ", destination-"+destinationCity);
		service.setVisitedSources(new HashSet<String>());
		return ResponseEntity.ok(service.doesRouteExist(sourceCity.toLowerCase(), destinationCity.toLowerCase()) ? "Yes" : "No");
	}

}
