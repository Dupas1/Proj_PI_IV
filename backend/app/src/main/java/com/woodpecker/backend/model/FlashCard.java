package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "flashcards")
public class FlashCard {
    @Id
    private String id;
    private String question;
    private String answer;
    private String category;
    private Difficulty difficulty;
    private Date timeSkip;
    private int numberReview;
    private String idUser;

}
