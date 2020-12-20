package com.example.datawarehouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PositiveNegativeScore {

    @Id
    private Integer score;

    private Integer count;
}
