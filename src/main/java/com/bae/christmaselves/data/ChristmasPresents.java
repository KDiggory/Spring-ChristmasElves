package com.bae.christmaselves.data;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ChristmasPresents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private Integer numNeeded;
	private String colour;
	

	public ChristmasPresents(Integer id, String type, Integer numNeeded, String colour) {
		super();
		this.id = id;
		this.type = type;
		this.numNeeded = numNeeded;
		this.colour = colour;

	}

	public ChristmasPresents() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumNeeded() {
		return numNeeded;
	}

	public void setNumNeeded(Integer numNeeded) {
		this.numNeeded = numNeeded;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, id, numNeeded, type);
	}
	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChristmasPresents other = (ChristmasPresents) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(id, other.id)
				&& Objects.equals(numNeeded, other.numNeeded) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ChristmasPresents [id=" + id + ", type=" + type + ", numNeeded=" + numNeeded + ", colour=" + colour
				+ "]";
	}

	

	

	
	
	

}
