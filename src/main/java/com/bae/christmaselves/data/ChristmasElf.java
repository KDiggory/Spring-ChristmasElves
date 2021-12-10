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
public class ChristmasElf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private Double height;
	private String favouriteFood;
	private String bestToy;
	private boolean isNice;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "id") 
//	private List<ChristmasTeam> team;
	
	
	public ChristmasElf(Integer id, String name, Integer age, Double height, String favouriteFood, String bestToy,
			boolean isNice) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.favouriteFood = favouriteFood;
		this.bestToy = bestToy;
		this.isNice = isNice;
//		this.team = team;
	}
	public ChristmasElf(String name, Integer age, Double height, String favouriteFood, String bestToy,
			boolean isNice) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.favouriteFood = favouriteFood;
		this.bestToy = bestToy;
		this.isNice = isNice;
//		this.team = team;
	}

	public ChristmasElf() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	public String getBestToy() {
		return bestToy;
	}

	public void setBestToy(String bestToy) {
		this.bestToy = bestToy;
	}

	
	public boolean isNice() {
		return isNice;
	}

	public void setNice(boolean isNice) {
		this.isNice = isNice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, bestToy, favouriteFood, height, id, isNice, name);
	}
//	public Integer getTeamID() {
//		return teamID;
//	}
//	public void setTeamID(Integer teamID) {
//		this.teamID = teamID;
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChristmasElf other = (ChristmasElf) obj;
		return Objects.equals(age, other.age) && Objects.equals(bestToy, other.bestToy)
				&& Objects.equals(favouriteFood, other.favouriteFood) && Objects.equals(height, other.height)
				&& Objects.equals(id, other.id) && isNice == other.isNice && Objects.equals(name, other.name);
//				&& Objects.equals(teamID, other.teamID);
	}
	@Override
	public String toString() {
		return "ChristmasElf [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", favouriteFood="
				+ favouriteFood + ", bestToy=" + bestToy + ", isNice=" + isNice + "]";
	}

	

	

	
	
	
	
	


	

}
