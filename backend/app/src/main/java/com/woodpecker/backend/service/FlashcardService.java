package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.FlashcardRequest;
import com.woodpecker.backend.dtos.FlashcardResponse;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.repository.FlashcardRepository;
import com.woodpecker.backend.service.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository repository;

    public FlashcardResponse create(String categoryId, FlashcardRequest request){
        FlashCard flashcard = new FlashCard();
        flashcard.setQuestion(request.getQuestion());
        flashcard.setAnswer(request.getAnswer());
        flashcard.setCategory(request.getCategory());
        flashcard.setCategoryId(categoryId);

        repository.save(flashcard);

        return createResponse(flashcard);
    }

    public FlashcardResponse updateByUser(String id, FlashcardRequest request){
        Optional<FlashCard> flashCard = repository.findById(id);
        flashCard.get().setCategory(request.getCategory());
        flashCard.get().setQuestion(request.getQuestion());
        flashCard.get().setAnswer(request.getAnswer());
        return createResponse(flashCard.get());
    }

    public FlashcardResponse udpateByReview(String id, FlashcardRequest request) throws Exception{

        Optional<FlashCard> flashCard = repository.findById(id);
        ReviewService reviewService = new ReviewService();
        LocalDate finalDate = reviewService.calculateReview(request.getDifficulty(),request.getNumberReview());
        flashCard.get().setTimeSkip(finalDate);
        flashCard.get().setNumberReview(flashCard.get().getNumberReview() + 1);

        return createResponse(flashCard.get());
    }

    public List<FlashcardResponse> findAllByCategoryId(String categoryId){
        List<FlashcardResponse> responses = new ArrayList<>();
        List<FlashCard> flashCards = repository.findAllByCategoryId(categoryId);
        if(!flashCards.isEmpty()) {
            flashCards.forEach(flashCard -> responses.add(createResponse(flashCard)));
            return responses;
        }
        return null;
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
        response.setCategoryId(flashcard.getCategoryId());

        return response;
    }

    public FlashCard findById(String id) {
        Optional<FlashCard> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
