package com.woodpecker.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class FlashCard {
    private String titulo;
    private String resposta;
    private String categoria;
    private Enum dificuldade;
    private Date proximaRevisao;

}
