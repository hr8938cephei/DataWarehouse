package com.example.datawarehouse.pojo;

import com.example.datawarehouse.model.EmotionScore;
import com.example.datawarehouse.model.Score;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreCount {

    private Integer score;

    private Integer count;

    public ScoreCount(Score score) {
        this.score = score.getScore();
        this.count = score.getMovieCount();
    }

    public ScoreCount(EmotionScore emotionScore) {
        this.score = emotionScore.getEmotionScore();
        this.count = emotionScore.getMovieCount();
    }
}
