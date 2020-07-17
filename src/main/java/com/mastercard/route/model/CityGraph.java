package com.mastercard.route.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CityGraph {

	private Map<CityVertex, Set<CityVertex>> adjucentVertices = new HashMap<CityVertex, Set<CityVertex>>();

	public Map<CityVertex, Set<CityVertex>> getAdjucentVertices() {
		return adjucentVertices;
	}
 
	
	public Set<CityVertex> getAdjucentCities(String city){
		return adjucentVertices.get(new CityVertex(city));	
	}

}
