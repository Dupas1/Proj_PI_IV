package com.woodpecker.backend.dtos;

import java.time.LocalDate;

public class ResultReview extends Order {
    private LocalDate finalDate;
    private int numberReview;

    public ResultReview() {
        super("ResultReview");
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public int getNumberReview() {
        return numberReview;
    }

    public void setNumberReview(int numberReview) {
        this.numberReview = numberReview;
    }

}
