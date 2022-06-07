package com.store.petfish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.petfish.Repository.AquariumReady;
import com.store.petfish.service.PetFishService;

@RestController
@RequestMapping("/fish-store")
public class PetFishController {
	
	@Autowired
	PetFishService petFishService;
	
	@GetMapping("/fish-for-aqua")
	public String fetchAllFishForAquarium(@RequestParam String userId) {
		return petFishService.fetchFishDetails(userId).getFishSelected();
		
	}
	
	@PostMapping("/create-Aquarium")
	public void createAquarium(@RequestBody AquariumReady aquariumReady) {
		petFishService.performValidation(aquariumReady);
	}

}
