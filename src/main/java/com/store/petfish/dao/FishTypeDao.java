package com.store.petfish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.petfish.Repository.AquariumReady;
import com.store.petfish.Repository.FishType;

@Repository
public interface FishTypeDao extends JpaRepository<FishType, String> {
	
	public FishType findByFishName(String fishName);

}
