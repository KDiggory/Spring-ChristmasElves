//package com.bae.christmaselves.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
//
//import com.bae.christmaselves.data.ChristmasElf;
//
//@Service
//public class ChristmasElfServiceList implements ChristmasElfService{
//	
//	private List<ChristmasElf> christmasElves = new ArrayList<ChristmasElf>();
//
//	
//	// take out any front end things - this does the logic
//	
//	public ChristmasElf createElf( ChristmasElf elf) {
//		this.christmasElves.add(elf);
//		ChristmasElf created = this.christmasElves.get(this.christmasElves.size() - 1);
//		return created;
//	}
//
//
//	public List<ChristmasElf> getAllElves() {
//		return this.christmasElves;
//	}
//
//
//	public ChristmasElf getElfById(Integer id) {
//		System.out.println("ID: " + id);
//		for (ChristmasElf elf : christmasElves) { // could switch this with a case statement? might be better?
//			if (elf.getId() == id) {
//				System.out.println("Elf: " + elf.toString());
//				return elf;
//			}
//		}
//		return null;
//	}
//
//	public ChristmasElf getElfByName(String name) {
//		System.out.println("Name: " + name);
//		for (ChristmasElf elf : christmasElves) {
//			if (elf.getName().equals(name)) {
//				System.out.println("Elf: " + elf.toString());
//				return elf;
//			}
//		}
//		return null;
//	}
//
//
//	public ChristmasElf updateElf(Integer id, ChristmasElf newElf) {
//		System.out.println("ID: " + id);
//		System.out.println("Elf: " + newElf.toString());
//		for (ChristmasElf elf : christmasElves) {
//			if (elf.getId() == id) {
//				elf.setName(newElf.getName());
//				elf.setAge(newElf.getAge());
//				elf.setHeight(newElf.getHeight());
//				elf.setFavouriteFood(newElf.getFavouriteFood());
//				elf.setBestToy(newElf.getBestToy());
//				elf.setNice(newElf.isNice());
//				return elf;
//			}
//		}
//		return null;
//	}
//
//	public ChristmasElf updateElfByName(String name, ChristmasElf newElf) {
//		System.out.println("Name: " + name);
//		System.out.println("Elf: " + newElf.toString());
//		for (ChristmasElf elf : christmasElves) {
//			if (elf.getName().equals(name)) {
//				elf.setId(newElf.getId());
//				elf.setAge(newElf.getAge());
//				elf.setHeight(newElf.getHeight());
//				elf.setFavouriteFood(newElf.getFavouriteFood());
//				elf.setBestToy(newElf.getBestToy());
//				elf.setNice(newElf.isNice());
//				return elf;
//				
//			}
//		}
//		return null;
//	}
//
////	@DeleteMapping("/deleteElf/{id}") // this deletes by index
////	public ResponseEntity<ChristmasElf>  deleteElf(@PathVariable Integer id) {
////		ResponseEntity<ChristmasElf> response = new ResponseEntity<ChristmasElf>(HttpStatus.NO_CONTENT);
////		christmasElves.remove(id.intValue());
////		return response;
////	}
//
//	// this deletes by id - it works but thows an internal server error
//	public void deleteElf(Integer id) {
//		for (ChristmasElf elf : christmasElves) {
//			if (elf.getId() == id) {
//				christmasElves.remove(elf);
//			}
//		}
//	}
//
//}
