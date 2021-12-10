package com.bae.christmaselves.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.christmaselves.data.ChristmasElf;
import com.bae.christmaselves.repo.ChristmasElvesRepo;

@Service
public class ChristmasElfServiceDB  implements ChristmasElfService {
	
	private ChristmasElvesRepo repo;
	
	
	@Autowired
	public ChristmasElfServiceDB(ChristmasElvesRepo repo) {
		super();
		this.repo = repo;
	}

	public ChristmasElf createElf(ChristmasElf elf) {
		ChristmasElf created = this.repo.save(elf); // saves to the database
		return created;
	}

	
	public List<ChristmasElf> getAllElves() {
		return this.repo.findAll();
	}

	
	public ChristmasElf getElfById(Integer id) {
		return this.repo.findById(id).get() ;
	}

	
	public ChristmasElf getElfByName(String name) {
		return this.repo.getByName(name); 
	}

	
	public ChristmasElf updateElf(Integer id, ChristmasElf newElf) {
		ChristmasElf existing = this.repo.getById(id);
		existing.setName(newElf.getName());
		existing.setAge(newElf.getAge());
		existing.setBestToy(newElf.getBestToy());
		existing.setHeight(newElf.getHeight());
		existing.setFavouriteFood(newElf.getFavouriteFood());
		existing.setAge(newElf.getAge());
		existing.setNice(newElf.isNice());
		return this.repo.save(existing);
	}

	
	public ChristmasElf updateElfByName(String name, ChristmasElf newElf) {
		ChristmasElf existing = this.repo.getByName(name);
		existing.setAge(newElf.getAge());
		existing.setBestToy(newElf.getBestToy());
		existing.setHeight(newElf.getHeight());
		existing.setFavouriteFood(newElf.getFavouriteFood());
		existing.setAge(newElf.getAge());
		existing.setNice(newElf.isNice());
		return this.repo.save(existing);
	}


	public void deleteElf(Integer id) {
		this.repo.deleteById(id);
	}

}
