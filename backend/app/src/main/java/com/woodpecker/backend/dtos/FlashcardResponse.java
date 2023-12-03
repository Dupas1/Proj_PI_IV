package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Category;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.User;

import java.util.Date;

public class FlashcardResponse
{
    private String id;
    private String question;
    private String answer;
    private String category;
    private Difficulty difficulty;
    private Date timeSkip;
    private int numberReview;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
