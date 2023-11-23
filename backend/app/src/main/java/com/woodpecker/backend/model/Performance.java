package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "performances")
public class Performance {
    @Id
    private String id;
    private String memory;
    private int overload;
    private String activity;
}
