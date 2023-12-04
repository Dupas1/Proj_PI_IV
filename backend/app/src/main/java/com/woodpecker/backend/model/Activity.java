package com.woodpecker.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private float averageReview;
    private Week week;

    public Activity() {
        this.averageReview = 0;
        this.week = new Week();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(float averageReview) {
        this.averageReview = averageReview;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public static class Week{
        private int sunday;
        private int monday;
        private int tuesday;
        private int wednesday;
        private int thursday;
        private int friday;
        private int saturday;

        public Week() {
            this.sunday = 0;
            this.monday = 0;
            this.tuesday = 0;
            this.wednesday = 0;
            this.thursday = 0;
            this.friday = 0;
            this.saturday = 0;

            //TODO: Precisa pensar para update quando a semana resetar
        }

        public int getSunday() {
            return sunday;
        }

        public void setSunday(int sunday) {
            this.sunday = sunday;
        }

        public int getMonday() {
            return monday;
        }

        public void setMonday(int monday) {
            this.monday = monday;
        }

        public int getTuesday() {
            return tuesday;
        }

        public void setTuesday(int tuesday) {
            this.tuesday = tuesday;
        }

        public int getWednesday() {
            return wednesday;
        }

        public void setWednesday(int wednesday) {
            this.wednesday = wednesday;
        }

        public int getThursday() {
            return thursday;
        }

        public void setThursday(int thursday) {
            this.thursday = thursday;
        }

        public int getFriday() {
            return friday;
        }

        public void setFriday(int friday) {
            this.friday = friday;
        }

        public int getSaturday() {
            return saturday;
        }

        public void setSaturday(int saturday) {
            this.saturday = saturday;
        }
    }
}

