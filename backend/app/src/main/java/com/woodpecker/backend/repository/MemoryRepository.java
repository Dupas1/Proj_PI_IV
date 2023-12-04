package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Memory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends MongoRepository<Memory, String> {
}
