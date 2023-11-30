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

        public String[] getMaster() {
            return master;
        }

        public void setMaster(String[] master) {
            this.master = master;
        }

        public String[] getNavigator() {
            return navigator;
        }

        public void setNavigator(String[] navigator) {
            this.navigator = navigator;
        }

        public String[] getExplorer() {
            return explorer;
        }

        public void setExplorer(String[] explorer) {
            this.explorer = explorer;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMemoryRate() {
        return memoryRate;
    }

    public void setMemoryRate(int memoryRate) {
        this.memoryRate = memoryRate;
    }

    public int getMemoryHealth() {
        return memoryHealth;
    }

    public void setMemoryHealth(int memoryHealth) {
        this.memoryHealth = memoryHealth;
    }
}
