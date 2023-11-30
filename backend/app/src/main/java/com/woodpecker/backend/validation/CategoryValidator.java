package com.woodpecker.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String> {

    private List<String> createdCategories;

    public CategoryValidator(){
        this.createdCategories = List.of("nomes");
    }

    @Override
    public void initialize(ValidCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String category, ConstraintValidatorContext context) {
        return category == null || createdCategories.contains(category.toLowerCase());
    }
}
