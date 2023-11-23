package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "configurations")
public class Configuration {
    @Id
    private String id;
    private boolean darkMode;
    private boolean notifications;
    private String language;
    private String typeStudy; //Ou colocar isso como Enum
}
