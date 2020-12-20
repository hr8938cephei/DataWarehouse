package com.example.datawarehouse.pojo;

import com.example.datawarehouse.model.Movie;
import lombok.Data;

@Data
public class MovieInfo {

    private String productId;

    private String title;

    private Integer versionCount;

    private Integer score;

    private Integer emotionScore;

    public MovieInfo(Movie movie) {
        this.productId = movie.getProductId();
        this.title = movie.getTitle();
        this.versionCount = movie.getVersionCount();
        this.score = movie.getScore().getScore();
        this.emotionScore = movie.getEmotionScore().getEmotionScore();
    }
}
