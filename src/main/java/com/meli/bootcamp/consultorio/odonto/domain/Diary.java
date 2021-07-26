package com.meli.bootcamp.consultorio.odonto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "diaries")
public class Diary {
    @Id
    private String id;

    @Field(name = "start_time")
    private LocalDateTime startTime;

    @Field(name = "ending_time")
    private LocalDateTime endingTime;

    @DBRef
    private Dentist dentist;

    @DBRef
    private List<Turn> turns;

    public Diary() {
    }

    public Diary(String id, LocalDateTime startTime, LocalDateTime endingTime, Dentist dentist, List<Turn> turns) {
        this.id = id;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.dentist = dentist;
        this.turns = turns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}
