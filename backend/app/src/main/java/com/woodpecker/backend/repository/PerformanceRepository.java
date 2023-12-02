package com.woodpecker.backend.repository;

import com.woodpecker.backend.dtos.PerformanceResponse;
import com.woodpecker.backend.model.Performance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends MongoRepository<Performance, String> {
}
