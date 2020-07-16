package com.mastercard.route.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/connected")
	  public boolean doesRouteExist(@RequestParam String sourceCity, @RequestParam String destinationCity) {
		service.setVisitedSources(new HashSet<String>());
	    return service.doesRouteExist(sourceCity, destinationCity);
	  }
	
}
