package com.example.datawarehouse.repository.repoImpl;

import com.example.datawarehouse.dto.QueryByScoreDto;
import com.example.datawarehouse.dto.ScoreType;
import com.example.datawarehouse.model.Movie;
import com.example.datawarehouse.repository.MovieRepo;
import com.example.datawarehouse.repository.repoMethods.MovieRepoMethods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class MovieRepoImpl implements MovieRepoMethods {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<Movie> findByTitle(String title, Integer limit) {
        return movieRepo.findByTitleContaining("%" + title.toLowerCase() + "%", limit);
    }

    @Override
    public List<Movie> findByScore(QueryByScoreDto queryByScoreDto) {
        if (queryByScoreDto.getScoreType() == ScoreType.NORMAL) {
            switch (queryByScoreDto.getOperator()) {
                case EQUALS:
                    return movieRepo.findByScoreEquals(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
                case LESS_THAN:
                    return movieRepo.findByScoreLessThan(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
                default:
                    return movieRepo.findByScoreGreaterThan(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
            }
        } else {
            switch (queryByScoreDto.getOperator()) {
                case EQUALS:
                    return movieRepo.findByEmotionScoreEquals(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
                case LESS_THAN:
                    return movieRepo.findByEmotionScoreLessThan(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
                default:
                    return movieRepo.findByEmotionScoreGreaterThan(queryByScoreDto.getScore(), queryByScoreDto.getLimit());
            }
        }
    }
}
