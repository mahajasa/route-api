package com.mastercard.route.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.route.model.CityGraph;
import com.mastercard.route.model.CityVertex;

@Service
public class RouteService {
	
	@Autowired
	CityGraph cityGraph;
	
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean doesRouteExist(String source, String destination) {
		boolean resultValue = false;
		
		Set<String> visited = new HashSet<String>();
		List<CityVertex> adjucentVertices = cityGraph.getAdjucentCities(source);
		
		if(adjucentVertices!=null && adjucentVertices.size()>0) {
			for(CityVertex citiVertex : adjucentVertices) {
				if(citiVertex.getName().equals(destination))
					return true;
				else
					visited.add(citiVertex.getName());
			}
			
			for(String visitedCity : visited) {
				resultValue = doesRouteExist(visitedCity, destination);
				if(resultValue)
					return true;
			}
		}
		
		return resultValue;
	}
}
