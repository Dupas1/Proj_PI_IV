package com.woodpecker.backend.dtos;

import java.util.List;

public class PreferencesResponse {
    private String id;
    private boolean hasAccident;
    private boolean hasDisease;
    private int stageLoseMemory;
    private List<String> studiesPreferences;
    private List<String> areasInterest;
    private String studiesDifficulties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasAccident() {
        return hasAccident;
    }

    public void setHasAccident(boolean hasAccident) {
        this.hasAccident = hasAccident;
    }

    public boolean isHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(boolean hasDisease) {
        this.hasDisease = hasDisease;
    }

    public int getStageLoseMemory() {
        return stageLoseMemory;
    }

    public void setStageLoseMemory(int stageLoseMemory) {
        this.stageLoseMemory = stageLoseMemory;
    }

    public List<String> getStudiesPreferences() {
        return studiesPreferences;
    }

    public void setStudiesPreferences(List<String> studiesPreferences) {
        this.studiesPreferences = studiesPreferences;
    }

    public List<String> getAreasInterest() {
        return areasInterest;
    }

    public void setAreasInterest(List<String> areasInterest) {
        this.areasInterest = areasInterest;
    }

    public String getStudiesDifficulties() {
        return studiesDifficulties;
    }

    public void setStudiesDifficulties(String studiesDifficulties) {
        this.studiesDifficulties = studiesDifficulties;
    }
}
