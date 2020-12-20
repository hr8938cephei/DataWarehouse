package com.example.datawarehouse.dto;

import lombok.Data;

@Data
public class QueryByTimeDto {

    private Integer startYear;

    private Integer startMonth;

    private Integer startDay;

    private Integer endYear;

    private Integer endMonth;

    private Integer endDay;

    public QueryByTimeDto(String startTimeStr, String endTimeStr) {
        setStartTime(startTimeStr);
        setEndTime(endTimeStr);
    }

    private void setStartTime(String startTimeStr) {
        String[] time = startTimeStr.split("-");
        setStartYear(Integer.valueOf(time[0]));
        setStartMonth(Integer.valueOf(time[1]));
        setStartDay(Integer.valueOf(time[2]));
    }

    private void setEndTime(String endTimeStr) {
        String[] time = endTimeStr.split("-");
        setEndYear(Integer.valueOf(time[0]));
        setEndMonth(Integer.valueOf(time[1]));
        setEndDay(Integer.valueOf(time[2]));
    }
}
