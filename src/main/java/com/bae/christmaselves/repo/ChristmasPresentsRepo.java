package com.bae.christmaselves.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.christmaselves.data.ChristmasPresents;

@Repository
public interface ChristmasPresentsRepo extends JpaRepository<ChristmasPresents, Integer> {

	
	List<ChristmasPresents> getAllByColour(String colour);
}
