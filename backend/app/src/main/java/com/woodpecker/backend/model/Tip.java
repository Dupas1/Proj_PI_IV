package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tips")
public class Tip {
    @Id
    private String id;
    private String tip;
}
