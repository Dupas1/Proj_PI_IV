package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUid(String uid);

    Optional<User> findByEmail(String email);
}
