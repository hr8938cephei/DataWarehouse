package com.example.datawarehouse.repository;

import com.example.datawarehouse.model.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends CrudRepository<Score, Integer> {

//    @Query("select s.movieCount from Score s where s.score = :score")
//    Integer countByScoreEquals(@Param("score") Integer score);
//
//    @Query("select sum(s.movieCount) from Score s where  s.score >= :score")
//    Integer countByScoreGreaterThanEqual(@Param("score") Integer score);
//
//    @Query("select sum(s.movieCount) from Score s where s.score <= :score")
//    Integer countByScoreLessThanEqual(@Param("score") Integer score);

    List<Score> findAll();
}
