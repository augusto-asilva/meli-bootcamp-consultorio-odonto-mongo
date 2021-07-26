package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.TurnStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnStatusRepository extends MongoRepository<TurnStatus, String> {

    TurnStatus findTurnStatusByName(String name);
}
