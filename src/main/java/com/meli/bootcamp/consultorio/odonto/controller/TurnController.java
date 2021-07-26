package com.meli.bootcamp.consultorio.odonto.controller;

import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import com.meli.bootcamp.consultorio.odonto.domain.Turn;
import com.meli.bootcamp.consultorio.odonto.domain.User;
import com.meli.bootcamp.consultorio.odonto.dto.TurnFormDTO;
import com.meli.bootcamp.consultorio.odonto.service.DiaryService;
import com.meli.bootcamp.consultorio.odonto.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turns")
public class TurnController {

    TurnService turnService;
    DiaryService diaryService;

    @Autowired
    public TurnController(TurnService turnService, DiaryService diaryService) {

        this.turnService = turnService;
    }

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getAll() {
        return turnService.findAll();
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String insertTurn(@RequestBody TurnFormDTO turnFormDTO) {
        turnService.save(turnFormDTO);
        return "inserted";
    }

    @GetMapping("/completed")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getCompletedTurns() {
        return turnService.findTurnsByTurnStatusCompleted();
    }

    @GetMapping("/completed/{date}/patients")
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getPatientsWithCompletedTurnsAtEspecificDay(@PathVariable String date) {
        LocalDate day = LocalDate.parse(date);
        return turnService.findPatientByTurnCompletedAndDays(day);
    }

    @GetMapping("/waiting")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getWaitingTurns() {
        return turnService.findTurnsByTurnStatusWaiting();
    }

    @GetMapping("/completed/{date}/patients")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getWaitingTurnsAtEspecificDay(@PathVariable String date) {
        LocalDate day = LocalDate.parse(date);
        return turnService.findTurnWaitingAtDay(day);
    }

    @GetMapping("/cancelled")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getCancelledTurns() {
        return turnService.findTurnsByTurnStatusCancelled();
    }

    @GetMapping("/rescheduled")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getRescheduledTurns() {
        return turnService.findTurnsByTurnStatusRescheduled();
    }

    @GetMapping("/rescheduled/dentist/{codeMp}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getRescheduledTurns(String codeMp) {
        List<Turn> turns = diaryService.getDiaryByDentistCodeMp(codeMp).getTurns();
        return turns.stream()
                .filter(turn -> turn.getTurnStatus().getName().equals("remarcado"))
                .collect(Collectors.toList());
    }
}
