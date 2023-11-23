package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "progresses")
public class Progress {
    @Id
    private String id;
    private int averageHitRate;
    private ArrayList<Boolean> frequency;
    private ArrayList<Integer> performance; //Tem que limitar essa lista ate 15
}
