package com.example.datawarehouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = { "time", "video", "director", "score", "positiveNegativeScore" })
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    private Video video;

    @ManyToOne(fetch = FetchType.EAGER)
    private Director director;

    @ManyToOne(fetch = FetchType.EAGER)
    private Score score;

    @ManyToOne(fetch = FetchType.EAGER)
    private PositiveNegativeScore positiveNegativeScore;
}
