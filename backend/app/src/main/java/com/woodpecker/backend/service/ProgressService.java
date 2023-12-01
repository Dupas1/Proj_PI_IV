package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.ProgressRequest;
import com.woodpecker.backend.dtos.ProgressResponse;
import com.woodpecker.backend.model.Progress;
import com.woodpecker.backend.repository.ProgressRepository;
import com.woodpecker.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProgressService {

    @Autowired
    ProgressRepository repository;

    @Autowired
    UserRepository userRepository;

    public ProgressResponse update(String uid, ProgressRequest request){

        Progress progress = userRepository.findByUid(uid).getProgress();
        progress.setAverageHitRate(request.getAverageHitRate());
        progress.getFrequency().add(request.isFrequency());
        progress.getPerformance().add(request.getPerformance());

        repository.save(progress);
        return createResponse(progress);
    }

    public ProgressResponse findByUid(String uid){
        Progress progress = userRepository.findByUid(uid).getProgress();
        return createResponse(progress);
    }

    private ProgressResponse createResponse(Progress progress){

        ProgressResponse response = new ProgressResponse();
        response.setId(progress.getId());
        response.setFrequency(progress.getFrequency());
        response.setAverageHitRate(progress.getAverageHitRate());
        response.setPerformance(progress.getPerformance());

        return response;
    }
}
