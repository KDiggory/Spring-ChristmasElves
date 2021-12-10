package com.bae.christmaselves.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.data.ChristmasPresents;
import com.bae.christmaselves.service.ChristmasPresentService;

@RestController
public class ChristmasPresentController {

	private ChristmasPresentService service;

	@Autowired
	public ChristmasPresentController(ChristmasPresentService service) {
		super();
		this.service = service;
	}


	@PostMapping("/createPresent")
	public ResponseEntity<ChristmasPresents> createPresent(@RequestBody ChristmasPresents present) {
		ChristmasPresents created = this.service.createPresent(present);
		ResponseEntity<ChristmasPresents> response = new ResponseEntity<ChristmasPresents>(present, HttpStatus.CREATED);
		return response;
	} 
	
	@GetMapping("/getAllPresents") // 200
	public ResponseEntity<List<ChristmasPresents>> getAllPresents() {
		return ResponseEntity.ok(this.service.getAllPresents());
	}
	
	@GetMapping("/getPresentById/{id}")
	public ChristmasPresents getPresentById(@PathVariable Integer id) {
		return this.service.getPresentById(id);
	}

	@GetMapping("/getPresesntByColour/{colour}")
	public List<ChristmasPresents> getPresesntByColour(@PathVariable String colour) {
		return this.service.getPresesntByColour(colour);
	}
	@PutMapping("/updatePresent/{id}") 
	public ResponseEntity<ChristmasPresents> updateElf(@PathVariable Integer id, @RequestBody ChristmasPresents newPresent) {
		ChristmasPresents body = this.service.updatePresent(id, newPresent);
		ResponseEntity<ChristmasPresents> response = new ResponseEntity<ChristmasPresents>(body, HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/deletePresent/{id}") 
	public ResponseEntity<ChristmasPresents> deletePresent(@PathVariable Integer id) {
		this.service.deletePresent(id);
		ResponseEntity<ChristmasPresents> response = new ResponseEntity<ChristmasPresents>(HttpStatus.NO_CONTENT);
		return response;
	}
	
}
