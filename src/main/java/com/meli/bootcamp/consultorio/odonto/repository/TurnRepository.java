package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findTurnByTurnStatusName(String turnStatusName);

}
