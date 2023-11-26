package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.FlashcardRequest;
import com.woodpecker.backend.dtos.FlashcardResponse;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository repository;
    private User user;

    public FlashcardResponse create(FlashcardRequest request){
        FlashCard flashcard = new FlashCard();
        flashcard.setQuestion(request.getQuestion());
        flashcard.setAnswer(request.getAnswer());
        flashcard.setCategory(request.getCategory());
        //flashcard.setIdUser(user.getUid());

        repository.save(flashcard);

        return createResponse(flashcard);
    }

    public List<FlashcardResponse> getAll() {
        List<FlashcardResponse> responses = new ArrayList<>();
        List<FlashCard> flashcards = repository.findAll();

        if(!flashcards.isEmpty()){
            flashcards.forEach(flashCard -> responses.add(createResponse(flashCard)));
        }

        return responses;
    }

    private FlashcardResponse createResponse(FlashCard flashcard){

        FlashcardResponse response = new FlashcardResponse();
        response.setId(flashcard.getId());
        response.setQuestion(flashcard.getQuestion());
        response.setAnswer(flashcard.getAnswer());
        response.setCategory(flashcard.getCategory());
        response.setDifficulty(flashcard.getDifficulty());
        response.setTimeSkip(flashcard.getTimeSkip());
        response.setNumberReview(flashcard.getNumberReview());

        return response;
    }
}
