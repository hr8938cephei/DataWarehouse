package com.example.datawarehouse.dto;

import lombok.Data;

@Data
public class QueryByTimeDto {

    private Integer year;

    private Integer season;

    private Integer month;

    private Integer day;

    private TimeGranularity timeGranularity;

//    public QueryByTimeDto(String startTimeStr, String endTimeStr) {
//        setStartTime(startTimeStr);
//        setEndTime(endTimeStr);
//    }
//
//    private void setStartTime(String startTimeStr) {
//        String[] time = startTimeStr.split("-");
//        setStartYear(Integer.valueOf(time[0]));
//        setStartMonth(Integer.valueOf(time[1]));
//        setStartDay(Integer.valueOf(time[2]));
//    }
//
//    private void setEndTime(String endTimeStr) {
//        String[] time = endTimeStr.split("-");
//        setEndYear(Integer.valueOf(time[0]));
//        setEndMonth(Integer.valueOf(time[1]));
//        setEndDay(Integer.valueOf(time[2]));
//    }

    public QueryByTimeDto(TimeGranularity timeGranularity, String timeStr) {
        this.timeGranularity = timeGranularity;

        setTime(timeStr);
    }

    private void setTime(String timeStr) {
        switch (this.timeGranularity) {
            case DAY:
                setDayTime(timeStr);
                break;
            case MONTH:
                setMonthTime(timeStr);
                break;
            case SEASON:
                setSeasonTime(timeStr);
                break;
            default:
                setYearTime(timeStr);
                break;
        }
    }

    private void setDayTime(String timeStr) {
        String[] time = timeStr.split("-");
        this.year = Integer.valueOf(time[0]);
        this.month = Integer.valueOf(time[1]);
        this.day = Integer.valueOf(time[2]);
    }

    private void setMonthTime(String timeStr) {
        String[] time = timeStr.split("-");
        this.year = Integer.valueOf(time[0]);
        this.month = Integer.valueOf(time[1]);
    }

    private void setSeasonTime(String timeStr) {
        String[] time = timeStr.split("-");
        this.year = Integer.valueOf(time[0]);
        this.season = Integer.valueOf(time[1]);
    }

    private void setYearTime(String timeStr) {
        this.year = Integer.valueOf(timeStr);
    }
}
