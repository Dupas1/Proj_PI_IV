package com.woodpecker.backend.dtos;

import com.woodpecker.backend.model.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;


public class FlashcardRequest {

    private String id;
    @NotBlank
    private String question;
    @NotBlank
    private String answer;
    private String category;
    @NotNull(message = "Difficultity cannot be null")
    private Difficulty difficulty;
    private String idUser;


}
