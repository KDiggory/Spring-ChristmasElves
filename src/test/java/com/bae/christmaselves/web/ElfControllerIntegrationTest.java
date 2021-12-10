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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.christmaselves.data.ChristmasElf;
import com.fasterxml.jackson.databind.ObjectMapper;

// boots the entire context
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the mockmvc object
@Sql(scripts = {"classpath:elf-schema.sql", "classpath:elf-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ElfControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc; // the class that performs our requests
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate()  throws Exception{
		ChristmasElf testElf = new ChristmasElf("Happy", 123, 0.5, "candy", "train", true);
		String testElfAsJSON = this.mapper.writeValueAsString(testElf);
		
		RequestBuilder req = post("/createElf").contentType(MediaType.APPLICATION_JSON)
				.content(testElfAsJSON);
		
		ChristmasElf testCreatedElf = new ChristmasElf(4, "Happy", 123, 0.5, "candy", "train", true);
		String testCreatedElfAsJSON = this.mapper.writeValueAsString(testCreatedElf);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedElfAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception { 
		List<ChristmasElf> testElf = List.of(new ChristmasElf(1, "Happy", 123, 0.5, "candy", "train", true), 
				new ChristmasElf(2, "Skippy", 56, 0.5, "caramel", "skipping rope", true), 
				new ChristmasElf(3, "Smiley", 322, 0.5, "sausages", "pencils", true));
		String testElfAsJSON = this.mapper.writeValueAsString(testElf);
		
		RequestBuilder req = get("/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testElfAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	
	@Test
	void testGetElfById() throws Exception {
		ChristmasElf testElf = new ChristmasElf(1, "Happy", 123, 0.5, "candy", "train", true);
		String testElfAsJSON = this.mapper.writeValueAsString(testElf);
		RequestBuilder req = get("/getElfById/1");
		
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testElfAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void testGetElfByName() throws Exception {
		ChristmasElf testElf = new ChristmasElf(1, "Happy", 123, 0.5, "candy", "train", true);
		String testElfAsJSON = this.mapper.writeValueAsString(testElf);
		
		
		RequestBuilder req = get("/getElfByName/Happy");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testElfAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		// id ther
		
	}
	
	@Test
	void testUpdateElf() throws Exception {
		ChristmasElf testElfUpdate = new ChristmasElf(1, "Princess Sparkles", 123, 0.5, "candy", "train", true);
		String testElfUpdateAsJSON = this.mapper.writeValueAsString(testElfUpdate);
		
		RequestBuilder req = put("/updateElf/1").contentType(MediaType.APPLICATION_JSON)
				.content(testElfUpdateAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testElfUpdateAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdateElfByName() throws Exception {
		ChristmasElf testElfUpdate = new ChristmasElf(1, "Happy", 470, 0.5, "caramel", "train", true);
		String testElfUpdateAsJSON = this.mapper.writeValueAsString(testElfUpdate);
		
		RequestBuilder req = put("/updateElfByName/Happy").contentType(MediaType.APPLICATION_JSON)
				.content(testElfUpdateAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testElfUpdateAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	}
	
	@Test
	void testDeleteElf() throws Exception {
		RequestBuilder req = delete("/deleteElf/1").contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatusGet = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatusGet);
	}

}
