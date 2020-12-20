package com.example.datawarehouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private Integer season;

    private Integer month;

    private Integer day;

    private Integer yearCount;

    private Integer seasonCount;

    private Integer monthCount;

    private Integer dayCount;
}
