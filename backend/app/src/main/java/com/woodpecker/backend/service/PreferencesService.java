package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.PreferencesRequest;
import com.woodpecker.backend.dtos.PreferencesResponse;
import com.woodpecker.backend.model.Preference;
import com.woodpecker.backend.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PreferencesService {

    @Autowired
    PreferenceRepository repository;

    public PreferencesResponse create(PreferencesRequest preferencesRequest){

        Preference preference = new Preference();
        preference.setHasAccident(preferencesRequest.hasAccident());
        preference.setHasDisease(preferencesRequest.hasDisease());
        preference.setStageLoseMemory(preferencesRequest.getStageLoseMemory());
        preference.setStudiesPreferences(preferencesRequest.getStudiesPreferences());
        preference.setAreasInterest(preferencesRequest.getAreasInterest());
        preference.setStudiesDifficulties(preferencesRequest.getStudiesDifficulties());

        repository.save(preference);
        return createResponse(preference);
    }

    public PreferencesResponse findByUid(String uid){
        Preference preferences = repository.findByUid(uid);
        return createResponse(preferences);
    }

    public PreferencesResponse update(String uid, PreferencesRequest request){

        Preference preferences = repository.findByUid(uid);
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
