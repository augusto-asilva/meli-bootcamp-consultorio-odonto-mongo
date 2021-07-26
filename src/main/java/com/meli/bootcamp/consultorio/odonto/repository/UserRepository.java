package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByDni(String dni);
}
