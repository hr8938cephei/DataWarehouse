package com.example.datawarehouse.utils;

public class TimeAccumulator {

    public long totalMilliseconds = 0;

    private long startTime;


    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.totalMilliseconds = System.currentTimeMillis() - startTime;
    }

    public long getTotalTime() {
        return this.totalMilliseconds;
    }
}
