package com.store.petfish.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.petfish.Repository.AquariumReady;
import com.store.petfish.Repository.AquariumType;
import com.store.petfish.Repository.FishType;
import com.store.petfish.dao.AquariumTypeDao;
import com.store.petfish.dao.FishTypeDao;
import com.store.petfish.dao.PetFishDao;
import com.store.petfish.service.PetFishService;

@Service
public class PetFishServiceImpl implements PetFishService {
	
	@Autowired
	PetFishDao petFishDao;
	
	@Autowired
	AquariumTypeDao aquariumTypeDao;
	
	@Autowired
	FishTypeDao fishTypeDao;


	@Override
	public AquariumReady fetchFishDetails(String userId) {
		return petFishDao.findByUserId(userId);
	}


	@Override
	public String performValidation(AquariumReady aquariumReady) {
		String fishSelected = aquariumReady.getFishSelected();
		boolean goldCheck = fishSelected.contains("Gold Fish");
		boolean guppiesCheck = fishSelected.contains("Guppies");
		String aquariumSelected = aquariumReady.getAquariumSelected();
		boolean fishExistingWithThreeOrMoreFins =  false;
		try {
			if (goldCheck && guppiesCheck) {
				throw new Exception("Gold Fish and Guppies can't go in same tank");
			} else {
				AquariumType aquariumType = aquariumTypeDao.findByAquaName(aquariumSelected.trim());
				if (aquariumType.getAquaWaterCapacity() <= 75) {
					for (String fishName : fishSelected.split(",")) {
						FishType fishType = fishTypeDao.findByFishName(fishName.trim());
						if (fishType.getFins() >= 3 ) {
							fishExistingWithThreeOrMoreFins = true;
							break;
						}
					}
					if (fishExistingWithThreeOrMoreFins) {
						throw new Exception("Fish with 3 or more fins can't go in 75 Litres or less tank");
					} else {
						petFishDao.save(aquariumReady);
					}
				} else {
					petFishDao.save(aquariumReady);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return null;
	}

}
