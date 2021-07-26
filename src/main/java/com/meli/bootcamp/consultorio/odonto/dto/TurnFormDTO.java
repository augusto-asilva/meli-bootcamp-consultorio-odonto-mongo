package com.meli.bootcamp.consultorio.odonto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import com.meli.bootcamp.consultorio.odonto.domain.Turn;
import com.meli.bootcamp.consultorio.odonto.domain.TurnStatus;
import com.meli.bootcamp.consultorio.odonto.domain.User;

import java.time.LocalDate;

public class TurnFormDTO {

    private LocalDate days;

    private Diary diary;

    private String turnStatus;

    @JsonProperty("patient")
    private String patientDni;

    public TurnFormDTO() {
    }

    public TurnFormDTO(LocalDate days, Diary diary, String turnStatus, String patientDni) {
        this.days = days;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patientDni = patientDni;
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

    public String getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(String turnStatus) {
        this.turnStatus = turnStatus;
    }

    public String getPatientDni() {
        return patientDni;
    }

    public void setPatientDni(String patientDni) {
        this.patientDni = patientDni;
    }

    public Turn parseToTurn(TurnStatus turnStatus, User patient) {
        return new Turn(this.days, this.diary, turnStatus, patient);
    }
}
