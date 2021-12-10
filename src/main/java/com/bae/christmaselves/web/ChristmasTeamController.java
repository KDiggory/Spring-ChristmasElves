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
import com.bae.christmaselves.data.ChristmasTeam;
import com.bae.christmaselves.service.ChristmasTeamService;

@RestController
public class ChristmasTeamController {
	
	private ChristmasTeamService service;
	
	
	@Autowired
	public ChristmasTeamController(ChristmasTeamService service) {
		super();
		this.service = service;
	}

	
	
//	public ChristmasTeamController() {
//		super();
//		// TODO Auto-generated constructor stub
//	}



	@PostMapping("/createTeam")
	public ResponseEntity<ChristmasTeam> createTeam(@RequestBody ChristmasTeam team) {
		ChristmasTeam created = this.service.createTeam(team);
		ResponseEntity<ChristmasTeam> response = new ResponseEntity<ChristmasTeam>(team, HttpStatus.CREATED);
		return response;
	} 
	
	@GetMapping("/getAllTeams") // 200
	public ResponseEntity<Object> getAllTeams() {
		return ResponseEntity.ok(this.service.getAllTeams());
	}
	
	@GetMapping("/getTeamById/{id}")
	public ChristmasTeam getTeamById(@PathVariable Integer id) {
		return this.service.getTeamById(id);
	}

	
	@PutMapping("/updateTeam/{id}") 
	public ResponseEntity<ChristmasTeam> updateTeam(@PathVariable Integer id, @RequestBody ChristmasTeam newTeam) {
		ChristmasTeam body = this.service.updateTeam(id, newTeam);
		ResponseEntity<ChristmasTeam> response = new ResponseEntity<ChristmasTeam>(body, HttpStatus.ACCEPTED);
		return response;
	}
	
	@DeleteMapping("/deleteTeam/{id}") 
	public ResponseEntity<ChristmasTeam> deleteTeam(@PathVariable Integer id) {
		this.service.deleteTeam(id);
		ResponseEntity<ChristmasTeam> response = new ResponseEntity<ChristmasTeam>(HttpStatus.NO_CONTENT);
		return response;
	}

}
