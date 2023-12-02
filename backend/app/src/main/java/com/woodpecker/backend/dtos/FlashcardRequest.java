package com.woodpecker.backend.dtos;

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
    @ValidCategory(message = "Category is not valid.")
    private String category;
    private Difficulty difficulty;

    private User uid;

    public User getUid() {
        return uid;
    }

    public void setIdUser(User uid) {
        this.uid = uid;
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

}
