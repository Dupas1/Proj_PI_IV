package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.PerformanceRequest;
import com.woodpecker.backend.dtos.PerformanceResponse;
import com.woodpecker.backend.model.Performance;
import com.woodpecker.backend.model.Settings;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.repository.ActivityRepository;
import com.woodpecker.backend.repository.MemoryRepository;
import com.woodpecker.backend.repository.PerformanceRepository;
import com.woodpecker.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    @Autowired
    PerformanceRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MemoryRepository memoryRepository;
    @Autowired
    ActivityRepository activityRepository;

    public PerformanceResponse update(String uid, PerformanceRequest request){

        Performance performance = userRepository.findByUid(uid).getPerformance();

        performance.setOverload(request.getOverload());
        performance.setActivity(request.getActivity());
        performance.setMemory(request.getMemory());

        //TODO: Talvez tenha que revisar como vai pegar os dados do request da Performance, pois esses campos atualmente só são uma referência ao BD.

        repository.save(performance);
        return createResponse(performance);
    }

    public Performance initialize(){

        Performance performance = new Performance();

        memoryRepository.save(performance.getMemory());
        activityRepository.save(performance.getActivity());
        repository.save(performance);

        return performance;
    }

    public PerformanceResponse findByUid(String uid){
        return createResponse(userRepository.findByUid(uid).getPerformance());
    }

    public PerformanceResponse createResponse(Performance performance){
        PerformanceResponse response = new PerformanceResponse();
        response.setId(performance.getId());
        response.setOverload(performance.getOverload());
        response.setActivity(performance.getActivity());
        response.setMemory(performance.getMemory());
        return response;
    }
}
