package com.store.petfish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.petfish.Repository.AquariumReady;

@Repository
public interface PetFishDao extends JpaRepository<AquariumReady, String> {
	
	public AquariumReady findByUserId(String userId);

}
