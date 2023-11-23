package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private float averageReview;
    private Week week;

    public static class Week{
        private int sunday;
        private int monday;
        private int tuesday;
        private int wednesday;
        private int thursday;
        private int friday;
        private int saturday;

        //TODO: Fazer os getters e setters dessa classe interna
    }

}

