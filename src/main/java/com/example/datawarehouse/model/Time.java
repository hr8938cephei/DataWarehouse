package com.example.datawarehouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeId;

    @Min(1900)
    @Max(2020)
    private Integer year;

    @Min(1)
    @Max(4)
    private Integer season;

    @Min(1)
    @Max(12)
    private Integer month;

    @Min(1)
    @Max(31)
    private Integer day;

    @Min(0)
    private Integer yearCount;

    @Min(0)
    private Integer seasonCount;

    @Min(0)
    private Integer monthCount;

    @Min(0)
    private Integer dayCount;
}
