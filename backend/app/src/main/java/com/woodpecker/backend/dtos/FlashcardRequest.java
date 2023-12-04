package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Category;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.validation.ValidCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;


public class FlashcardRequest {

    @NotBlank(message = "Question cannot be blank.")
    @NotNull(message = "Question cannot be null.")
    private String question;
    @NotBlank(message = "Answer cannot be blank.")
    @NotNull(message = "Answer cannot be null.")
    private String answer;
    private String category;
    private String difficulty;
    private int numberReview;


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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }
}
