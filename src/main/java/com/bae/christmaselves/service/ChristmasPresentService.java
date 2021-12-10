package com.bae.christmaselves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.data.ChristmasPresents;
import com.bae.christmaselves.repo.ChristmasElvesRepo;
import com.bae.christmaselves.repo.ChristmasPresentsRepo;

@Service
public class ChristmasPresentService {
	
	private ChristmasPresentsRepo repo;

	
	@Autowired
	public ChristmasPresentService(ChristmasPresentsRepo repo) {
		super();
		this.repo = repo;
	}

	public ChristmasPresents createPresent(ChristmasPresents present) {
		ChristmasPresents created = this.repo.save(present); // saves to the database
		return created;
	}

	public List<ChristmasPresents> getAllPresents() {
		return this.repo.findAll();
	}

	public void deletePresent(Integer id) {
		this.repo.deleteById(id);
		
	}

	public ChristmasPresents updatePresent(Integer id, ChristmasPresents newPresent) {
		ChristmasPresents existing = this.repo.getById(id);
		existing.setType(newPresent.getType());
		existing.setNumNeeded(newPresent.getNumNeeded());
		existing.setColour(newPresent.getColour());
		return this.repo.save(existing);
	}

	public List<ChristmasPresents> getPresesntByColour(String colour) {
		return this.repo.getAllByColour(colour);
	}

	public ChristmasPresents getPresentById(Integer id) {
		return this.repo.getById(id) ;
	}


	

}
