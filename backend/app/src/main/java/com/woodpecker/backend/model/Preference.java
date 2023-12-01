package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "preferences")
public class Preference {
    @Id
    private String id;
    private boolean hasAccident;
    private boolean hasDisease;
    private int stageLoseMemory;
    private List<String> studiesPreferences;
    private List<String> areasInterest;
    private String studiesDifficulties;

    public Preference() {
        this.hasAccident = false;
        this.hasDisease = false;
        this.stageLoseMemory = 0;
        this.studiesPreferences = new ArrayList<String>();
        this.areasInterest = new ArrayList<String>();
        this.studiesDifficulties = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return studiesDifficulties;
    }

    public void setStudiesDifficulties(String studiesDifficulties) {
        this.studiesDifficulties = studiesDifficulties;
    }
}
