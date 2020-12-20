package com.example.datawarehouse.dto;

public enum Operator {
    LESS_THAN,
    EQUALS,
    GREATER_THAN;

    public static Operator createOperator(String operatorStr) {
        switch (operatorStr) {
            case "lt":
                return LESS_THAN;
            case "eq":
                return EQUALS;
            default:
                return GREATER_THAN;
        }
    }
}
