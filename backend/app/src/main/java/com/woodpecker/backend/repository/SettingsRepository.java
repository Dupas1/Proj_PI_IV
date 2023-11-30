package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Settings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingsRepository extends MongoRepository<Settings, String> {

    Settings findByUid(String uid);
}
