package com.bae.christmaselves.service;

import java.util.List;

import com.bae.christmaselves.data.ChristmasElf;

public interface ChristmasElfService {
	
	public ChristmasElf createElf( ChristmasElf elf); 

	public List<ChristmasElf> getAllElves(); 

	public ChristmasElf getElfById(Integer id); 

	public ChristmasElf getElfByName(String name); 

	public ChristmasElf updateElf(Integer id, ChristmasElf newElf); 

	public ChristmasElf updateElfByName(String name, ChristmasElf newElf);
	
	public void deleteElf(Integer id); 

}
