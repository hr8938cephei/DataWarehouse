package com.example.datawarehouse.dto;

import lombok.Data;

@Data
public class QueryByScoreDto {

    private Integer score;

    private ScoreType scoreType;

    private Operator operator;

    private Integer limit;

    public QueryByScoreDto(ScoreType scoreType, Double score, String operatorStr, Integer limit) {
        this.scoreType = scoreType;
        this.score = (int)(score * 100);
        this.operator = Operator.createOperator(operatorStr);
        this.limit = limit;
    }
}
