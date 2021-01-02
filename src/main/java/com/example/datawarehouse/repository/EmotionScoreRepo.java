package com.example.datawarehouse.repository;

import com.example.datawarehouse.model.EmotionScore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmotionScoreRepo extends CrudRepository<EmotionScore, Integer> {

//    @Query("select em.movieCount from EmotionScore em where em.emotionScore = :emotionScore")
//    Integer countByEmotionScoreEquals(@Param("emotionScore") Integer emotionScore);
//
//    @Query("select sum(em.movieCount) from EmotionScore em where  em.emotionScore >= :emotionScore")
//    Integer countByEmotionScoreGreaterThanEqual(@Param("emotionScore") Integer emotionScore);
//
//    @Query("select sum(em.movieCount) from EmotionScore em where em.emotionScore <= :emotionScore")
//    Integer countByEmotionScoreLessThanEqual(@Param("emotionScore") Integer emotionScore);

    List<EmotionScore> findAll();
}
