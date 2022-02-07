package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.FruitDetails;
import com.bezkoder.springjwt.repository.FruitRepository;

@Service
public class FruitsServiceImpl implements FruitsService {
	
	@Autowired
	private FruitRepository fruitRepository;

	@Override
	public FruitDetails saveFruitDetails(FruitDetails fruit) {
		// TODO Auto-generated method stub
		return fruitRepository.save(fruit);
	}

	@Override
	public List<FruitDetails> getAllFruitDetails() {
		// TODO Auto-generated method stub
		return fruitRepository.findAll();
	}

	@Override
	public Optional<FruitDetails> getFruitDetailsById(Long id) {
		// TODO Auto-generated method stub
		return fruitRepository.findById(id);
	}

	@Override
	public void deleteFruitDetailsById(Long id) {
		// TODO Auto-generated method stub

		fruitRepository.deleteById(id);
		
	}

	@Override
	public void updateFruitDetails(FruitDetails fruit) {
		// TODO Auto-generated method stub
		fruitRepository.save(fruit);
	}

}
