package com.example.datawarehouse.repository;

import com.example.datawarehouse.model.Movie;
import com.example.datawarehouse.repository.repoMethods.MovieRepoMethods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepo extends CrudRepository<Movie, String>, MovieRepoMethods {

    @Query(
            value = "select m.* from actor_movie am natural join movie m where am.actor_name = :actorName limit :limit",
            nativeQuery = true
    )
    List<Movie> findByActorName(@Param("actorName") String actorName, @Param("limit") Integer limit);

    @Query(
            value = "select m.* from director_movie dm natural join movie m where dm.director_name = :directorName limit :limit",
            nativeQuery = true
    )
    List<Movie> findByDirectorName(@Param("directorName") String directorName, @Param("limit") Integer limit);

    @Query(
            value = "select m.* from label_movie lm natural join movie m where lm.label_name = :labelName limit :limit",
            nativeQuery = true
    )
    List<Movie> findByLabelName(@Param("labelName") String labelName, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.score > :score limit :limit",
            nativeQuery = true
    )
    List<Movie> findByScoreGreaterThan(@Param("score") Integer score, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.score = :score limit :limit",
            nativeQuery = true
    )
    List<Movie> findByScoreEquals(@Param("score") Integer score, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.score < :score limit :limit",
            nativeQuery = true
    )
    List<Movie> findByScoreLessThan(@Param("score") Integer score, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.emotion_score > :emotionScore limit :limit",
            nativeQuery = true
    )
    List<Movie> findByEmotionScoreGreaterThan(@Param("emotionScore") Integer emotionScore, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.emotion_score = :emotionScore limit :limit",
            nativeQuery = true
    )
    List<Movie> findByEmotionScoreEquals(@Param("emotionScore") Integer emotionScore, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where m.emotion_score < :emotionScore limit :limit",
            nativeQuery = true
    )
    List<Movie> findByEmotionScoreLessThan(@Param("emotionScore") Integer emotionScore, @Param("limit") Integer limit);

    @Query(
            value = "select * from movie m where lower(m.title) like :likeStr limit :limit",
            nativeQuery = true
    )
    List<Movie> findByTitleContaining(@Param("likeStr") String likeStr, @Param("limit") Integer limit);
}
