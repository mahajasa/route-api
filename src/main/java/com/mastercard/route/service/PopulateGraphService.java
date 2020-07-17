package com.mastercard.route.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.mastercard.route.model.CityGraph;
import com.mastercard.route.model.CityVertex;

@Service
public class PopulateGraphService {

	private static final String seperator = ",";
	
	@Autowired
	CityGraph cityGraph;

	
	public void populateCityGraph() throws Exception{
        Resource resource = new ClassPathResource("cities.txt");
        InputStream inputStream = resource.getInputStream();
        try {
        	
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);
            StringTokenizer tokenizer = new StringTokenizer(data,"\r\n");
            
            while(tokenizer.hasMoreElements()) {
            	populateVertices(tokenizer.nextToken());
            }
            System.out.println("RouteApiApplication.run()");
            
        } catch (IOException e) {
        	System.out.println("IOException"+ e);
        }
	}
	
	private void populateVertices(String token) {
		String source = token.substring(0,token.indexOf(seperator));
		String destination = token.substring(token.indexOf(seperator)+1);
		
		CityVertex sourceVertex = new CityVertex(source.trim().toLowerCase());
		CityVertex destinationVertex = new CityVertex(destination.trim().toLowerCase());
    	
		if(cityGraph.getAdjucentVertices().containsKey(sourceVertex))
			cityGraph.getAdjucentVertices().get(sourceVertex).add(destinationVertex);
		else {
			Set<CityVertex> list = new HashSet<CityVertex>();
			list.add(destinationVertex);
			cityGraph.getAdjucentVertices().put(sourceVertex, list);
		}
		
		if(cityGraph.getAdjucentVertices().containsKey(destinationVertex))
			cityGraph.getAdjucentVertices().get(destinationVertex).add(sourceVertex);
		else {
			Set<CityVertex> list = new HashSet<CityVertex>();
			list.add(sourceVertex);
			cityGraph.getAdjucentVertices().put(destinationVertex, list);
		}
		
		
		}
}
