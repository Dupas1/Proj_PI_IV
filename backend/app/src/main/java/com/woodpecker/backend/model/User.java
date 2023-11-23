package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String psw;
    private String name;
    private String email;
    private Date entryDate;
    private String phone;
    private String gender;
    private String preferences;
    private String flashcards;
    private String performance;
    private String configurations;

}
