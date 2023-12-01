package com.woodpecker.backend.dtos;

import java.util.ArrayList;

public class ProgressResponse {
    private String id;
    private int averageHitRate;
    private ArrayList<Boolean> frequency;
    private ArrayList<Integer> performance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAverageHitRate() {
        return averageHitRate;
    }

    public void setAverageHitRate(int averageHitRate) {
        this.averageHitRate = averageHitRate;
    }

    public ArrayList<Boolean> getFrequency() {
        return frequency;
    }

    public void setFrequency(ArrayList<Boolean> frequency) {
        this.frequency = frequency;
    }

    public ArrayList<Integer> getPerformance() {
        return performance;
    }

    public void setPerformance(ArrayList<Integer> performance) {
        this.performance = performance;
    }
}
