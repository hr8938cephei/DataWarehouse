package com.example.datawarehouse.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeWrapper<T> {

    private T data;

    private long time;
}
