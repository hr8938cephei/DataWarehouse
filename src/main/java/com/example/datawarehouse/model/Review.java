package com.example.datawarehouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = { "user", "movie" })
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    private Integer upVote;

    private Integer downVote;

    private Double score;

    private Long timeStamp;

    @Lob
    private String summary;

    @Lob
    private String text;
}
