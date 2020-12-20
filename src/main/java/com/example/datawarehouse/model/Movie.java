package com.example.datawarehouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(exclude = { "time", "score", "emotionScore" })
@Entity
public class Movie {

    @Id
    @Column(length = 12)
    @Size(max = 12)
    private String productId;

    private String title;

    @Min(0)
    private Integer versionCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "score")
    private Score score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_score")
    private EmotionScore emotionScore;
}
