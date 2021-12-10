package com.bae.christmaselves.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.service.ChristmasElfService;
@CrossOrigin
@RestController

public class ElfController {


	private ChristmasElfService service;
	
	
	@Autowired // tells spring to fetch the service from the context, will make a controller and then put the service in it. 
				// This is dependency injection
	public ElfController(ChristmasElfService service) {
		super();
		this.service = service;
	}

// take out logic - this talks to websites
	
	@PostMapping("/createElf") // 201 - created
	public ResponseEntity<ChristmasElf> createElf(@RequestBody ChristmasElf elf) {
		ChristmasElf created = this.service.createElf(elf);
		ResponseEntity<ChristmasElf> response = new ResponseEntity<ChristmasElf>(elf, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll") // 200
	public ResponseEntity<List<ChristmasElf>> getAllElves() {
		return ResponseEntity.ok(this.service.getAllElves());
	}

	@GetMapping("/getElfById/{id}")
	public ResponseEntity<ChristmasElf> getElfById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.service.getElfById(id));
	}

	@GetMapping("/getElfByName/{name}")
	public ResponseEntity<ChristmasElf> getElfByName(@PathVariable String name) {
		return ResponseEntity.ok(this.service.getElfByName(name));
	}

	@PutMapping("/updateElf/{id}") 
	public ResponseEntity<ChristmasElf> updateElf(@PathVariable Integer id, @RequestBody ChristmasElf newElf) {
		ChristmasElf body = this.service.updateElf(id, newElf);
		ResponseEntity<ChristmasElf> response = new ResponseEntity<ChristmasElf>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@PutMapping("/updateElfByName/{name}") // this just adds a new one not updates
	public ResponseEntity<ChristmasElf> updateElf(@PathVariable String name, @RequestBody ChristmasElf newElf) {
		ChristmasElf body = this.service.updateElfByName(name, newElf);
		ResponseEntity<ChristmasElf> response = new ResponseEntity<ChristmasElf>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/deleteElf/{id}") 
	public ResponseEntity<ChristmasElf> deleteElf(@PathVariable Integer id) {
		this.service.deleteElf(id);
		ResponseEntity<ChristmasElf> response = new ResponseEntity<ChristmasElf>(HttpStatus.NO_CONTENT);
		return response;
	}
}