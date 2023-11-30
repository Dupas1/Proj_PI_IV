package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.SettingsRequest;
import com.woodpecker.backend.dtos.SettingsResponse;
import com.woodpecker.backend.model.Settings;
import com.woodpecker.backend.model.StudyType;
import com.woodpecker.backend.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository repository;

    public SettingsResponse create(SettingsRequest request){

        Settings settings = new Settings();
        settings.setLanguage(request.getLanguage());
        settings.setNotifications(request.isNotifications());
        settings.setDarkMode(true);
        settings.setStudyType(StudyType.HYBRID);

        repository.save(settings);

        return createResponse(settings);
    }

    public SettingsResponse findByUid(String uid){
        Settings settings = repository.findByUid(uid);
        return createResponse(settings);

    }

    public SettingsResponse update(String uid, SettingsRequest request){

        Settings settings = repository.findByUid(uid);
        settings.setLanguage(request.getLanguage());
        settings.setNotifications(request.isNotifications());
        settings.setStudyType(request.getStudyType());
        settings.setDarkMode(request.isDarkMode());
        repository.save(settings);

        return createResponse(settings);
    }

    private SettingsResponse createResponse(Settings settings){

        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setId(settings.getId());
        settingsResponse.setNotifications(settings.isNotifications());
        settingsResponse.setLanguage(settings.getLanguage());
        settingsResponse.setDarkMode(settings.isDarkMode());
        settingsResponse.setStudyType(settings.getStudyType());

        return settingsResponse;
    }
}
