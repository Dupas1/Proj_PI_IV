package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends MongoRepository<Progress, String> {
}
