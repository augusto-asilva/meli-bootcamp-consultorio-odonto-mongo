package com.meli.bootcamp.consultorio.odonto.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document(collation = "dentists")
public class Dentist extends User {

    @DBRef
    List<Diary> diaries;

    @Field(name = "code_mp")
    private String codeMp;

    public Dentist() {
    }

    public Dentist(String id, String password, String userStatus, String name, String lastName, String dni,
                   LocalDate birthDate, String phone, String email, Address address, List<Diary> diaries, String codeMp) {
        super(id, password, userStatus, name, lastName, dni, birthDate, phone, email, address);
        this.diaries = diaries;
        this.codeMp = codeMp;
    }

    public List<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = diaries;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }
}
