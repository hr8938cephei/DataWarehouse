package com.example.datawarehouse.repository.repoMethods;

import com.example.datawarehouse.dto.QueryByScoreDto;
import com.example.datawarehouse.model.Movie;

import java.util.List;

public interface MovieRepoMethods {

    List<Movie> findByTitle(String title, Integer limit);

    List<Movie> findByScore(QueryByScoreDto queryByScoreDto);
}
