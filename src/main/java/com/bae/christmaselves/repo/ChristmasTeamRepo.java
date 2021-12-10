package com.bae.christmaselves.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.christmaselves.data.ChristmasTeam;

@Repository
public interface ChristmasTeamRepo extends JpaRepository<ChristmasTeam, Integer> {

}
