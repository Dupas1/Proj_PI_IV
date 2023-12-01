package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.SettingsRequest;
import com.woodpecker.backend.dtos.SettingsResponse;
import com.woodpecker.backend.model.Settings;
import com.woodpecker.backend.model.StudyType;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.repository.SettingsRepository;
import com.woodpecker.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository repository;
    @Autowired
    private UserRepository userRepository;

    public SettingsResponse findByUid(String uid) throws Exception{
        User user = userRepository.findByUid(uid);
        if( user != null && user.getSettings() != null) return createResponse(user.getSettings());
        throw new Exception("Settings not found for user with uid:" + uid);
    }

    public SettingsResponse createOrUpdate(String uid, SettingsRequest request){

        Settings settings = userRepository.findByUid(uid).getSettings();
        if(settings == null) settings = new Settings();

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
