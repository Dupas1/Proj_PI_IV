package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.PerformanceRequest;
import com.woodpecker.backend.dtos.PerformanceResponse;
import com.woodpecker.backend.model.Performance;
import com.woodpecker.backend.model.User;
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

    public PerformanceResponse update(String uid, PerformanceRequest request){

        Performance performance = userRepository.findByUid(uid).getPerformance();

        performance.setOverload(request.getOverload());
        performance.setActivity(request.getActivity());
        performance.setMemory(request.getMemory());

        repository.save(performance);
        return createResponse(performance);
    }

    public PerformanceResponse findByUid(String uid){
        return createResponse(repository.findByUid(uid));
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
