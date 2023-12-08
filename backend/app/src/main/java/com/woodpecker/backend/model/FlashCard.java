package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "flashcards")
public class FlashCard {
    @Id
    private String id;
    private String question;
    private String answer;
    private String category;
    private Difficulty difficulty = Difficulty.BEGIN;
    private LocalDate timeSkip = LocalDate.now();
    private int numberReview = 0;

    //TODO: Criar uma variavel de referencia para o tema relacionado a esse flashcard.
    //TODO: Criar uma classe para Temas

    private String categoryId;

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
        if(category == null) this.category = "Sem Tema";
        else this.category = category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty)throws Exception {
        if(difficulty.equals("EASY")) this.difficulty = Difficulty.EASY;
        else if(difficulty.equals("MEDIUM")) this.difficulty = Difficulty.MEDIUM;
        else if(difficulty.equals("HARD")) this.difficulty = Difficulty.HARD;
        else if(difficulty.equals("WRONG")) this.difficulty = Difficulty.WRONG;
        else throw new Exception("Dificuldade invalida.");
    }

    public LocalDate getTimeSkip() {
        return timeSkip;
    }

    public void setTimeSkip(LocalDate timeSkip) {
        this.timeSkip = timeSkip;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

    public String getCategoryId() {return categoryId;}


    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
