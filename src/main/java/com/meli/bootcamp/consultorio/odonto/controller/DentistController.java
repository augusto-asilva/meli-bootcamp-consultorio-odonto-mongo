package com.meli.bootcamp.consultorio.odonto.controller;

import com.meli.bootcamp.consultorio.odonto.domain.Dentist;
import com.meli.bootcamp.consultorio.odonto.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }
    @GetMapping("/{codeMp}/turns/greater-than-two/at/{date}")
    public List<Dentist> getDentistsWithMoreThenTwoTurnsAtDay(@PathVariable String date, @PathVariable  String codeMp) {
        LocalDate day = LocalDate.parse(date);
        return dentistService.getDentistsWithMoreThenTwoTurnsAtDay(day, codeMp);
    }
}
