package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memories")
public class Memory {
    @Id
    private String id;
    private int memoryRate;
    private int memoryHealth;

    public static class KnowledgeDomain{
        private String[] master;
        private String[] navigator;
        private String[] explorer;

        //TODO: Fazer os getters e setters dessa classe interna
    }
}
