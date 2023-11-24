package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.FlashcardRequest;
import com.woodpecker.backend.dtos.FlashcardResponse;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @Autowired
    private FlashcardService service;

    @PostMapping    //isso significa que quando requisitar para o endpoint  /flashcard irá criar um flashcard
    public ResponseEntity<FlashcardResponse> create(@RequestBody FlashcardRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    public ResponseEntity<List<FlashcardResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
