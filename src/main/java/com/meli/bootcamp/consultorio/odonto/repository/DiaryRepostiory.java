package com.meli.bootcamp.consultorio.odonto.repository;

import com.meli.bootcamp.consultorio.odonto.domain.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DiaryRepostiory extends MongoRepository<Diary, String> {

    List<Diary> findDiariesByDentistCodeMp(String codeMp);

    Diary findDiaryByDentistCodeMp(String codeMp);

    List<Diary> findDiariesByStartTimeAfterAndEndingTimeBeforeAndDentistCodeMp(LocalDateTime start, LocalDateTime end,
                                                                               String codeMp);
}
