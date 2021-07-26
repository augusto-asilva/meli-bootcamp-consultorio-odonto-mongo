package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DentistRepository extends MongoRepository<Dentist, String> {
}
