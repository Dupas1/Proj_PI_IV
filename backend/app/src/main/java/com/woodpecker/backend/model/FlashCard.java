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
    private Difficulty difficulty = Difficulty.BEGIN;
    private Date timeSkip = new Date();
    private int numberReview = 0;

    //TODO: Criar uma variavel de referencia para o tema relacionado a esse flashcard.
    //TODO: Criar uma classe para Temas

    private User uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Date getTimeSkip() {
        return timeSkip;
    }

    public void setTimeSkip(Date timeSkip) {
        this.timeSkip = timeSkip;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

    public User getUid() {
        return uid;
    }


    public void setIdUser(User uid) {
        this.uid = uid;
    }

}
