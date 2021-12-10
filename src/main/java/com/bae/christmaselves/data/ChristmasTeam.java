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
public class ChristmasTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numMembers;
	private String teamName;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "team")
//	private List<ChristmasElf> elves;
//	
//	@JsonIgnore
//	@OneToMany(mappedBy = "team")
//	private List<ChristmasPresents> presents;
	
	

	public ChristmasTeam(Integer id, Integer numMembers, String teamName
			) {
		super();
		this.id = id;
		this.numMembers = numMembers;
		this.teamName = teamName;
//		this.elves = elves;
//		this.presents = presents;
	}

//	public List<ChristmasElf> getElves() {
//		return elves;
//	}
//
//	public void setElves(List<ChristmasElf> elves) {
//		this.elves = elves;
//	}
//
//	public List<ChristmasPresents> getPresents() {
//		return presents;
//	}
//
//	public void setPresents(List<ChristmasPresents> presents) {
//		this.presents = presents;
//	}

	public ChristmasTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumMembers() {
		return numMembers;
	}

	public void setNumMembers(Integer numMembers) {
		this.numMembers = numMembers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(elves, id, numMembers, presents, teamName);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ChristmasTeam other = (ChristmasTeam) obj;
//		return Objects.equals(elves, other.elves) && Objects.equals(id, other.id)
//				&& Objects.equals(numMembers, other.numMembers) && Objects.equals(presents, other.presents)
//				&& Objects.equals(teamName, other.teamName);
//	}
//
//	@Override
//	public String toString() {
//		return "ChristmasTeam [id=" + id + ", numMembers=" + numMembers + ", teamName=" + teamName + ", elves=" + elves
//				+ ", presents=" + presents + "]";
//	}


	

}
