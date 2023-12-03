package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findAllByUid(String userId);
}
