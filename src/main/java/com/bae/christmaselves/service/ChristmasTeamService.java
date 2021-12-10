package com.bae.christmaselves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.data.ChristmasPresents;
import com.bae.christmaselves.data.ChristmasTeam;
import com.bae.christmaselves.repo.ChristmasElvesRepo;
import com.bae.christmaselves.repo.ChristmasTeamRepo;


@Service
public class ChristmasTeamService {
	
	private ChristmasTeamRepo repo;
	
	
	@Autowired
	public ChristmasTeamService(ChristmasTeamRepo repo) {
		super();
		this.repo = repo;
	}

	public ChristmasTeam createTeam(ChristmasTeam team) {
		ChristmasTeam created = this.repo.save(team); // saves to the database
		return created;
	}

	public void deleteTeam(Integer id) {
		this.repo.deleteById(id);
		
	}

	public ChristmasTeam getTeamById(Integer id) {
		return this.repo.getById(id) ;
	}

	public ChristmasTeam updateTeam(Integer id, ChristmasTeam newTeam) {
		ChristmasTeam existing = this.repo.getById(id);
		existing.setNumMembers(newTeam.getNumMembers());
		existing.setTeamName(newTeam.getTeamName());
		return this.repo.save(existing);
	}

	public Object getAllTeams() {
		return this.repo.findAll();
	}

	

}
