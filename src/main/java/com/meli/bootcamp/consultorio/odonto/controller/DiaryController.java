package com.meli.bootcamp.consultorio.odonto.controller;

import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import com.meli.bootcamp.consultorio.odonto.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/dentist/{codeMp}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Diary> getDiariesForADentist(@PathVariable String codeMp) {
        return diaryService.getDiariesByDentistCodeMp(codeMp);
    }

}
