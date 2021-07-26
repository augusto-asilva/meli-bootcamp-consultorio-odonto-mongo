package com.meli.bootcamp.consultorio.odonto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "turns")
public class Turn {
    @Id
    private String id;

    private LocalDate days;

    @DBRef
    private Diary diary;

    @DBRef
    private TurnStatus turnStatus;

    @DBRef
    private User patient;

    public Turn() {
    }

    public Turn(String id, LocalDate days, Diary diary, TurnStatus turnStatus, User patient) {
        this.id = id;
        this.days = days;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }

    public Turn(LocalDate days, Diary diary, TurnStatus turnStatus, User patient) {
        this.days = days;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
        this.days = days;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }
}
