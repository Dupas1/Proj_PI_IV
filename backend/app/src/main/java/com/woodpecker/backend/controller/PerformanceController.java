package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.PerformanceResponse;
import com.woodpecker.backend.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/{uid}/performance")
public class PerformanceController {

    @Autowired
    PerformanceService service;

    @PostMapping
    public ResponseEntity<?> create(){
        return ResponseEntity.ok(service.create());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<PerformanceResponse> findByUid(@PathVariable String uid){
        return ResponseEntity.ok(service.findByUid(uid));
    }
}
