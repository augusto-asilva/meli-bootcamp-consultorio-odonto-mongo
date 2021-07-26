package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepostiory extends MongoRepository<Diary, String> {
}
