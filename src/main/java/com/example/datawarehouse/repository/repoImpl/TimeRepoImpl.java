package com.example.datawarehouse.repository.repoImpl;

import com.example.datawarehouse.dto.QueryByTimeDto;
import com.example.datawarehouse.repository.TimeRepo;
import com.example.datawarehouse.repository.repoMethods.TimeRepoMethods;
import org.springframework.beans.factory.annotation.Autowired;

public class TimeRepoImpl implements TimeRepoMethods {

    @Autowired
    private TimeRepo timeRepo;

    @Override
    public Integer countByTime(QueryByTimeDto queryByTimeDto) {
        return timeRepo.countByTime(
                queryByTimeDto.getStartYear(),
                queryByTimeDto.getStartMonth(),
                queryByTimeDto.getStartDay(),
                queryByTimeDto.getEndYear(),
                queryByTimeDto.getEndMonth(),
                queryByTimeDto.getEndDay()
        );
    }
}
