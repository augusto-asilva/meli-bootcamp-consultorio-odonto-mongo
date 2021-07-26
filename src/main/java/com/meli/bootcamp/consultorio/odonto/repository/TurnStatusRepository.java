package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.TurnStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends MongoRepository<TurnStatus, String> {

    TurnStatus findTurnStatusByName(String name);
}
