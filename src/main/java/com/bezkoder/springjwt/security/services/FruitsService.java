package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.FruitDetails;

public interface FruitsService {
	
	public FruitDetails saveFruitDetails(FruitDetails fruitDetails);
    public List<FruitDetails> getAllFruitDetails();
    public Optional<FruitDetails> getFruitDetailsById(Long id);
    public void deleteFruitDetailsById(Long id);
    public void updateFruitDetails(FruitDetails fruitDetails);
}
