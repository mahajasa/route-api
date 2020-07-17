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
	
	private Set<String> visitedSources;
	
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean doesRouteExist(String source, String destination) {
		visitedSources.add(source);
		boolean resultValue = false;
		
		Set<String> connections = new HashSet<String>();
		Set<CityVertex> adjucentVertices = cityGraph.getAdjucentCities(source);
		
		if(adjucentVertices!=null && adjucentVertices.size()>0) {
			for(CityVertex citiVertex : adjucentVertices) {
				if(citiVertex.getName().equalsIgnoreCase(destination))
					return true;
				else
					connections.add(citiVertex.getName());
			}
			
			for(String connection : connections) {
				if(!visitedSources.contains(connection)) {
					resultValue = doesRouteExist(connection, destination);
					if(resultValue)
						return true;
				}
			}
		}
		
		return resultValue;
	}


	public void setVisitedSources(Set<String> visitedSources) {
		this.visitedSources = visitedSources;
	}
	
	
	
}
