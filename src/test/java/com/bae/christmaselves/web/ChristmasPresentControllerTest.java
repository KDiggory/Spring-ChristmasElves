package com.bae.christmaselves.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.data.ChristmasPresents;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the mockmvc object
@Sql(scripts = {"classpath:elf-schema.sql", "classpath:elf-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ChristmasPresentControllerTest {
	
	@Autowired
	private MockMvc mvc; // the class that performs our requests
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate()  throws Exception{
		ChristmasPresents testPresent = new ChristmasPresents("red", 10, "train");
		String testPresentAsJSON = this.mapper.writeValueAsString(testPresent);
		
		RequestBuilder req = post("/createPresent").contentType(MediaType.APPLICATION_JSON)
				.content(testPresentAsJSON);
		
		ChristmasPresents testCreatedPresent = new ChristmasPresents(2, "red", 10, "train");
		String testCreatedPresentAsJSON = this.mapper.writeValueAsString(testCreatedPresent);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedPresentAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // this is not working
	void testGetAll() throws Exception {
		ChristmasPresents testPresent = new ChristmasPresents(1, "red", 10, "train");
		String testPresentAsJSON = this.mapper.writeValueAsString(List.of(testPresent));
		
		RequestBuilder req = get("/getAllPresents");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPresentAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	

	@Test
		void testGetElfById() throws Exception {
		ChristmasPresents testPresent = new ChristmasPresents(1, "red", 10, "train");
		String testPresentAsJSON = this.mapper.writeValueAsString(testPresent);
		RequestBuilder req = get("/getPresentById/1");
	
	
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPresentAsJSON);
	
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	
}
}
