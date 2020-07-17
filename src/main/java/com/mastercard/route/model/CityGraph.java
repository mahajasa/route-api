package com.mastercard.route.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityGraph {

	private Map<CityVertex, List<CityVertex>> adjucentVertices = new HashMap<CityVertex, List<CityVertex>>();

	public Map<CityVertex, List<CityVertex>> getAdjucentVertices() {
		return adjucentVertices;
	}
 
	
	public List<CityVertex> getAdjucentCities(String city){
		return adjucentVertices.get(new CityVertex(city));	
	}

}
