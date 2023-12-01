package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.PerformanceRequest;
import com.woodpecker.backend.dtos.PerformanceResponse;
import com.woodpecker.backend.service.PerformanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/performance/{uid}")
public class PerformanceController {

    @Autowired
    PerformanceService service;

    @PostMapping
    public ResponseEntity<?> update(@PathVariable String uid, @Valid @RequestBody PerformanceRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.update(uid, request));
    }

    @GetMapping
    public ResponseEntity<PerformanceResponse> findByUid(@PathVariable String uid){
        return ResponseEntity.ok(service.findByUid(uid));
    }

    private ResponseEntity<?> handleErrors(BindingResult bindingResult){

        List<String> validationErrors = bindingResult.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        //criando resposta de erro personalizada
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", new Date());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", validationErrors);
        response.put("path", "/performance");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
