package com.woodpecker.server;

public class CalculationReviewOrder extends Order {
    private int numberReview;
    private String difficulty;

    private static final long serialVersionUID = 1L;

    public CalculationReviewOrder(String difficulty, int numberReview) {
        super("CalculationReviewOrder");
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

    @Override
    public String toString() {
        return "CalculationReviewOrder{" +
                "numberReview=" + numberReview +
                ", dificulty='" + difficulty + '\'' +
                '}';
    }
}
