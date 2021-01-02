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
        Integer result;
        switch (queryByTimeDto.getTimeGranularity()) {
            case DAY:
                result = timeRepo.countByDay(queryByTimeDto.getYear(), queryByTimeDto.getMonth(), queryByTimeDto.getDay());
                break;
            case MONTH:
                result = timeRepo.countByMonth(queryByTimeDto.getYear(), queryByTimeDto.getMonth());
                break;
            case SEASON:
                result = timeRepo.countBySeason(queryByTimeDto.getYear(), queryByTimeDto.getSeason());
                break;
            default:
                result = timeRepo.countByYear(queryByTimeDto.getYear());
                break;
        }

        System.out.println(result);

        if (result == null) {
            result = 0;
        }

        return result;
    }
}
