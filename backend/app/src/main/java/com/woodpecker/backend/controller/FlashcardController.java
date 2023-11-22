package com.woodpecker.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @GetMapping("/review")      //isso significa que quando requisitar para o endpoint  /flashcard/review irá retornar todos os flashcards do dia para revisar
    public String getAllFlashcardOfDay(){
        //TODO: Fazer função para retornar todos os flashcards que precisam ser revisados no dia
        return "a";
    }
}
