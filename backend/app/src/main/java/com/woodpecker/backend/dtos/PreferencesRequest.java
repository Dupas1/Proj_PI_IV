package com.woodpecker.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PreferencesRequest {
    @NotNull(message = "Accident field cannot be null.")
    @NotBlank(message = "Accident field cannot be blank.")
    private boolean hasAccident;
    @NotNull(message = "Disease field cannot be null.")
    @NotBlank(message = "Disease field cannot be blank.")
    private boolean hasDisease;
    @NotNull(message = "Stage of lose memory field cannot be null.")
    @NotBlank(message = "Stage of lose memory field cannot be blank.")
    private int stageLoseMemory;
    @NotNull(message = "Studies preferences field cannot be null.")
    private List<String> studiesPreferences;
    @NotNull(message = "Areas of interest field cannot be null.")
    private List<String> areasInterest;
    @NotNull(message = "Study difficulties field cannot be null.")
    private String studyDifficulties;

    public boolean hasAccident() {
        return hasAccident;
    }

    public void setHasAccident(boolean hasAccident) {
        this.hasAccident = hasAccident;
    }

    public boolean hasDisease() {
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
        return studyDifficulties;
    }

    public void setStudiesDifficulties(String studiesDifficulties) {
        this.studyDifficulties = studiesDifficulties;
    }
}
