package com.meli.bootcamp.consultorio.odonto.service;

import com.meli.bootcamp.consultorio.odonto.domain.Dentist;
import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import com.meli.bootcamp.consultorio.odonto.repository.DentistRepository;
import com.meli.bootcamp.consultorio.odonto.repository.DiaryRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService {

    DentistRepository dentistRepository;
    DiaryRepostiory diaryRepostiory;

    @Autowired
    public DentistService(DentistRepository dentistRepository, DiaryRepostiory diaryRepostiory) {
        this.dentistRepository = dentistRepository;
        this.diaryRepostiory = diaryRepostiory;
    }

    public List<Dentist> getDentistsWithMoreThenTwoTurnsAtDay(LocalDate day, String codeMp) {
        LocalDateTime start = day.atStartOfDay();
        LocalDateTime end = day.atTime(23,59,59);
        List<Diary>  diaries = diaryRepostiory
                .findDiariesByStartTimeAfterAndEndingTimeBeforeAndDentistCodeMp(start, end, codeMp);

        List<Dentist> dentists = new ArrayList<>();

        diaries = diaries.stream().filter(diary -> diary.getTurns().size() >= 2).collect(Collectors.toList());

        diaries.forEach(diary -> dentists.add(diary.getDentist()));

        return dentists;
    }
}
