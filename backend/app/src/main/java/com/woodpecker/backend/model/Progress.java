package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "progresses")
public class Progress {
    @Id
    private String id;
    private int averageHitRate;
    private ArrayList<Boolean> frequency;
    private ArrayList<Integer> performance;

    public Progress() {
        this.averageHitRate = 0;
        this.frequency = new ArrayList<Boolean>();
        this.performance = new ArrayList<Integer>();
    }

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
