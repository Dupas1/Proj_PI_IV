package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Order;

public class CalculationReviewOrder extends Order {
    private int numberReview;
    private String difficulty;

    public CalculationReviewOrder(String difficulty, int numberReview) {
        this.numberReview = numberReview;
        this.difficulty = difficulty;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
