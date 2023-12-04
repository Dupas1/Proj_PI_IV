package com.woodpecker.server;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class ResultReview extends Order {
    private LocalDate finalDate;

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }
}
