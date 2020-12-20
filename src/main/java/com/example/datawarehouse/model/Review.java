package com.example.datawarehouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(exclude = { "user", "movie" })
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Size(max = 16)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @Size(max = 12)
    private Movie movie;

    @Min(0)
    private Integer upVote;

    @Min(0)
    private Integer downVote;

    @Min(0)
    @Max(5)
    private Integer score;

    @Min(0)
    @Max(1)
    private Double emotionScore;

    private Long timeStamp;
}
