package com.mastercard.route.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityGraph {

	private Map<CityVertex, List<CityVertex>> adjucentVertices = new HashMap<CityVertex, List<CityVertex>>();

	public Map<CityVertex, List<CityVertex>> getAdjucentVertices() {
		return adjucentVertices;
	}
 
	public void setAdjucentVertices(Map<CityVertex, List<CityVertex>> adjucentVertices) {
		this.adjucentVertices = adjucentVertices;
	}

	/**
	 * add vertices to map
	 * 
	 * @param city
	 */
	public void addVertex(String city) {
		CityVertex vertex = new CityVertex(city);
		adjucentVertices.putIfAbsent(vertex, new ArrayList<CityVertex>());
	}

	/**
	 * This method creates all edges among the vertices
	 * 
	 * @param sourceCity
	 * @param destinationCity
	 */
	public void addRoute(String sourceCity, String destinationCity) {
		CityVertex source = new CityVertex(sourceCity);
		CityVertex destination = new CityVertex(destinationCity);
		adjucentVertices.get(source).add(destination);
		adjucentVertices.get(destination).add(source);
	}
	
	
	public List<CityVertex> getAdjucentCities(String city){
		return adjucentVertices.get(new CityVertex(city));	
	}

}
