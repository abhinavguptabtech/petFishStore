package com.store.petfish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.petfish.Repository.AquariumReady;
import com.store.petfish.Repository.AquariumType;

@Repository
public interface AquariumTypeDao extends JpaRepository<AquariumType, String> {
	
	public AquariumType findByAquaName(String aquariumName);

}
