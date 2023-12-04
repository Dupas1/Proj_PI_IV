package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.User;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class CategoryRequest {
    private String name;
    private int length;
    private int priorityLevel;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

}
