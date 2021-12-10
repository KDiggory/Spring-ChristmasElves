package com.bae.christmaselves.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.christmaselves.data.ChristmasElf;

@Repository
public interface ChristmasElvesRepo extends JpaRepository<ChristmasElf, Integer> {
	
	// spring generates all basic CRUD functionality
	
	ChristmasElf getByName(String type);
	
	List<ChristmasElf> getAllByAgeGreaterThan(Integer age);
	

}
