package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.FruitDetails;

public interface FruitRepository extends JpaRepository<FruitDetails, Long> {

}
