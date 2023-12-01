package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository extends MongoRepository<Progress, String> {
    Progress findByUid(String uid);
}
