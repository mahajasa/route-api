package com.mastercard.route.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mastercard.route.model.CityGraph;

@Configuration
public class RoutesConfig {

	@Bean
	public CityGraph cityGraph(){
		return new CityGraph();
	}
}
