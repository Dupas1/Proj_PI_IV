package com.woodpecker.backend.dtos;

import java.util.ArrayList;

public class ProgressRequest {
    private int averageHitRate;
    private boolean frequency;
    private int performance;

    public int getAverageHitRate() {
        return averageHitRate;
    }

    public void setAverageHitRate(int averageHitRate) {
        this.averageHitRate = averageHitRate;
    }

    public boolean isFrequency() {
        return frequency;
    }

    public void setFrequency(boolean frequency) {
        this.frequency = frequency;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }
}
