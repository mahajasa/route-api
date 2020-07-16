package com.mastercard.route.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RouteApplicationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessageFalse() throws Exception {
		this.mockMvc.perform(get("/api/routes/connected").param("sourceCity", "Cary").param("destinationCity", "Raleigh")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(("false")));
	}
	@Test
	public void shouldReturnDefaultMessageTrue() throws Exception {
		this.mockMvc.perform(get("/api/routes/connected").param("sourceCity", "Boston").param("destinationCity", "New York")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(("true")));
	}
	
}