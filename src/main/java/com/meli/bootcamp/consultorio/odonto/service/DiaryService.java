package com.meli.bootcamp.consultorio.odonto.service;

import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import com.meli.bootcamp.consultorio.odonto.repository.DiaryRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    DiaryRepostiory diaryRepostiory;

    @Autowired
    public DiaryService(DiaryRepostiory diaryRepostiory) {
        this.diaryRepostiory = diaryRepostiory;
    }

    public List<Diary> getDiariesByDentistCodeMp(String codeMp) {
        return diaryRepostiory.findDiariesByDentistCodeMp(codeMp);
    }

    public Diary getDiaryByDentistCodeMp(String codeMp) {
        return diaryRepostiory.findDiaryByDentistCodeMp(codeMp);
    }
}
