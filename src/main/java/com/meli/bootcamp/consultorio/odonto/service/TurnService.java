package com.meli.bootcamp.consultorio.odonto.service;

import com.meli.bootcamp.consultorio.odonto.domain.Turn;
import com.meli.bootcamp.consultorio.odonto.dto.TurnFormDTO;
import com.meli.bootcamp.consultorio.odonto.repository.TurnRepository;
import com.meli.bootcamp.consultorio.odonto.repository.TurnStatusRepository;
import com.meli.bootcamp.consultorio.odonto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {


    TurnRepository turnRepository;
    TurnStatusRepository turnStatusRepository;
    UserRepository userRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository, TurnStatusRepository turnStatusRepository,
                       UserRepository userRepository) {
        this.turnRepository = turnRepository;
        this.turnStatusRepository = turnStatusRepository;
        this.userRepository = userRepository;
    }

    public List<Turn> findTurnsByTurnStatusCompleted() {
        return turnRepository.findTurnByTurnStatusName("completado");
    }

    public List<Turn> findTurnsByTurnStatusCancelled() {
        return turnRepository.findTurnByTurnStatusName("cancelado");
    }

    public List<Turn> findTurnsByTurnStatusWaiting() {
        return turnRepository.findTurnByTurnStatusName("pendente");
    }

    public List<Turn> findTurnsByTurnStatusRescheduled() {
        return turnRepository.findTurnByTurnStatusName("remarcado");
    }

    public List<Turn> findAll() {
        return turnRepository.findAll();
    }

    public void save(TurnFormDTO turnFormDTO) {

        Turn turnToSave = turnFormDTO.parseToTurn(
                turnStatusRepository.findTurnStatusByName(turnFormDTO.getTurnStatus()),
                userRepository.findUserByDni(turnFormDTO.getPatientDni())
                );

        turnRepository.insert(turnToSave);
    }
}
