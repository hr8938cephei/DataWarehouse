package com.example.datawarehouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = { "time", "score", "positiveNegativeScore" })
@Entity
public class Movie {

    @Id
    private String productId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    private Score score;

    @ManyToOne(fetch = FetchType.EAGER)
    private PositiveNegativeScore positiveNegativeScore;
}
