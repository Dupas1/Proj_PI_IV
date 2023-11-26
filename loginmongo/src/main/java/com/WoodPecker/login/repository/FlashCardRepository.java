package com.WoodPecker.login.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.WoodPecker.login.domain.FlashCard;

@Repository
public interface FlashCardRepository extends MongoRepository<FlashCard, String>{
	
	List<FlashCard> findByUserId(String userId);
}
