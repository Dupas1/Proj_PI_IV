package com.WoodPecker.login.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.WoodPecker.login.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
