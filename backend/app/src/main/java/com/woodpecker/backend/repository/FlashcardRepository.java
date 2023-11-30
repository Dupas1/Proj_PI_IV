package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.FlashCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends MongoRepository<FlashCard, String> {

}
