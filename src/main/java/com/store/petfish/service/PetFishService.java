package com.store.petfish.service;

import com.store.petfish.Repository.AquariumReady;

public interface PetFishService {
	
	public AquariumReady fetchFishDetails(String userId);
	
	public String performValidation(AquariumReady aquariumReady);

}
