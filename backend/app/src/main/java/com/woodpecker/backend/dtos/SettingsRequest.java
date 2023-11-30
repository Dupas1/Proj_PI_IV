package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.StudyType;
import jakarta.validation.constraints.NotNull;

public class SettingsRequest {
    @NotNull(message = "Notifications cannot be null.")
    private boolean notifications;
    @NotNull(message = "Language cannot be null.")
    private String language;

    private boolean darkMode;
    private StudyType studyType;


    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }
}
