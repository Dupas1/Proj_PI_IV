package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.CategoryRequest;
import com.woodpecker.backend.dtos.CategoryResponse;
import com.woodpecker.backend.model.Category;
import com.woodpecker.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public void initializeCategory(String uid){
        Category category = new Category("Sem tema", 0, uid);
        repository.save(category);
    }

    public CategoryResponse create(String uid, CategoryRequest request){
        Category category = new Category(request.getName(), request.getPriorityLevel(), uid);
        repository.save(category);
        return createResponse(category);
    }

    public List<CategoryResponse> findAllByUid(String uid){
        List<CategoryResponse> responses = new ArrayList<>();
        List<Category> categories = repository.findAllByUserId(uid);

        if(!categories.isEmpty()){
            categories.forEach( category -> responses.add(createResponse(category)));
        }
        return responses;
    }

    public CategoryResponse update(String id, CategoryRequest request){
        Optional<Category> category = repository.findById(id);
        return createResponse(category.get());
    }

    public boolean delete(String id){
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private CategoryResponse createResponse(Category category){
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setPriorityLevel(category.getPriorityLevel());
        response.setLength(category.getLength());
        response.setUserId(category.getUserId());

        return response;
    }
}
