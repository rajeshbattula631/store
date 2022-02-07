package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.FruitDetails;
import com.bezkoder.springjwt.security.services.FruitsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class FruitController {
	
	@Autowired
	private FruitsService fruitsService;

	 @GetMapping("/fruits")
	  public ResponseEntity<List<FruitDetails>> getAllFruits() {
	   
		 List<FruitDetails> fruits = fruitsService.getAllFruitDetails(); 
		 ResponseEntity<List<FruitDetails>> responseEntity = new ResponseEntity<List<FruitDetails>>(fruits, HttpStatus.ACCEPTED);
		 return responseEntity;
	  }

	  @GetMapping("/fruits/{id}")
	  public ResponseEntity<FruitDetails> getFruitById(@PathVariable("id") long id) {
		  Optional<FruitDetails> fruit = fruitsService.getFruitDetailsById(id);
		  ResponseEntity<FruitDetails> responseEntity = new ResponseEntity<FruitDetails>(fruit.get(), HttpStatus.ACCEPTED);
		  return responseEntity;
	  }

	  @PostMapping("/createFruit")
	  public ResponseEntity<FruitDetails> createFruit(@RequestBody FruitDetails fruit) {
		  FruitDetails createdFruit = fruitsService.saveFruitDetails(fruit);
		  ResponseEntity<FruitDetails> responseEntity = new ResponseEntity<FruitDetails>(createdFruit, HttpStatus.CREATED);
		  return responseEntity;
	  }

	  @PutMapping("/fruits/{id}")
	  public ResponseEntity<HttpStatus> updateFruit(@PathVariable("id") long id, @RequestBody FruitDetails fruitdata) {
		  //Optional<FruitDetails> fruit = fruitsService.getFruitDetailsById(id);
		  fruitsService.updateFruitDetails(fruitdata);
		  ResponseEntity<HttpStatus> responseEntity = new ResponseEntity<HttpStatus>(HttpStatus.OK);
		  return responseEntity;
	  }

	  @DeleteMapping("/fruits/{id}")
	  public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {
		  
		  fruitsService.deleteFruitDetailsById(id);
		  ResponseEntity<HttpStatus> responseEntity = new ResponseEntity<HttpStatus>(HttpStatus.OK);
		  return responseEntity;
	  }
}
