package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferenceRepository extends MongoRepository<Preference, String> {
    Preference findByUid(String uid);
}
