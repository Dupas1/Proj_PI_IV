package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "memories")
public class Memory {
    @Id
    private String id;
    private int memoryRate;
    private int memoryHealth;
    private KnowledgeDomain domain;

    public Memory() {
        this.memoryRate = 0;
        this.memoryHealth = 10;
        this.domain = new KnowledgeDomain();
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

    public KnowledgeDomain getDomain() {
        return domain;
    }

    public void setDomain(KnowledgeDomain domain) {
        this.domain = domain;
    }

    public static class KnowledgeDomain{
        private ArrayList<String> master;
        private ArrayList<String> navigator;
        private ArrayList<String> explorer;

        public KnowledgeDomain() {
            this.master = new ArrayList<String>();
            this.navigator = new ArrayList<String>();
            this.explorer = new ArrayList<String>();
        }


        public ArrayList<String> getMaster() {
            return master;
        }

        public void setMaster(ArrayList<String> master) {
            this.master = master;
        }

        public ArrayList<String> getNavigator() {
            return navigator;
        }

        public void setNavigator(ArrayList<String> navigator) {
            this.navigator = navigator;
        }

        public ArrayList<String> getExplorer() {
            return explorer;
        }

        public void setExplorer(ArrayList<String> explorer) {
            this.explorer = explorer;
        }

    }
}
