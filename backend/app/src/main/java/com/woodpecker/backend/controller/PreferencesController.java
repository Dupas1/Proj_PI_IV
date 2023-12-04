package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.PreferencesRequest;
import com.woodpecker.backend.dtos.PreferencesResponse;
import com.woodpecker.backend.service.PreferencesService;
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
@RequestMapping("/user/{uid}/preferences")
public class PreferencesController {

    @Autowired
    PreferencesService service;

    @GetMapping
    public ResponseEntity<PreferencesResponse> findPreferences(@PathVariable String uid){
        return ResponseEntity.ok(service.findByUid(uid));
    }
    @PutMapping
    public ResponseEntity<?> update(@PathVariable String uid, @Valid @RequestBody PreferencesRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return handleErrors(bindingResult);
        return ResponseEntity.ok(service.update(uid,request));
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
        response.put("path", "/preferences");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
