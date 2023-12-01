package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.PreferencesRequest;
import com.woodpecker.backend.dtos.PreferencesResponse;
import com.woodpecker.backend.model.Preference;
import com.woodpecker.backend.repository.PreferenceRepository;
import com.woodpecker.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PreferencesService {

    @Autowired
    PreferenceRepository repository;

    @Autowired
    UserRepository userRepository;

    public PreferencesResponse findByUid(String uid){
        Preference preferences = repository.findByUid(uid);
        return createResponse(preferences);
    }

    public PreferencesResponse createOrUpdate(String uid, PreferencesRequest request){

        Preference preferences = userRepository.findByUid(uid).getPreferences();
        if(preferences == null) preferences = new Preference();

        preferences.setHasAccident(request.hasAccident());
        preferences.setHasDisease(request.hasDisease());
        preferences.setStageLoseMemory(request.getStageLoseMemory());
        preferences.setStudiesPreferences(request.getStudiesPreferences());
        preferences.setAreasInterest(request.getAreasInterest());
        preferences.setStudiesDifficulties(request.getStudiesDifficulties());

        repository.save(preferences);
        return createResponse(preferences);
    }

    private PreferencesResponse createResponse(Preference preference){

        PreferencesResponse preferencesResponse = new PreferencesResponse();
        preferencesResponse.setId(preference.getId());
        preferencesResponse.setHasAccident(preference.hasAccident());
        preferencesResponse.setHasDisease(preference.hasDisease());
        preferencesResponse.setStageLoseMemory(preference.getStageLoseMemory());
        preferencesResponse.setStudiesPreferences(preference.getStudiesPreferences());
        preferencesResponse.setAreasInterest(preference.getAreasInterest());
        preferencesResponse.setStudiesDifficulties(preference.getStudiesDifficulties());

        return preferencesResponse;
    }
}
