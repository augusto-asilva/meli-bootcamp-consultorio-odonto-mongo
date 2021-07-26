package com.meli.bootcamp.consultorio.odonto.controller;

import com.meli.bootcamp.consultorio.odonto.domain.Turn;
import com.meli.bootcamp.consultorio.odonto.dto.TurnFormDTO;
import com.meli.bootcamp.consultorio.odonto.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {

    TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {

        this.turnService = turnService;
    }

    @GetMapping("")
    public List<Turn> getAll() {
        return turnService.findAll();
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String inserTurn(@RequestBody TurnFormDTO turnFormDTO) {
        turnService.save(turnFormDTO);
        return "inserted";
    }

    @GetMapping("/completed")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getCompletedTurns() {
        return turnService.findTurnsByTurnStatusCompleted();
    }

    @GetMapping("/waiting")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Turn> getWaitingTurns() {
        return turnService.findTurnsByTurnStatusWaiting();
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
}
