package com.example.datawarehouse.repository.repoMethods;

import com.example.datawarehouse.dto.QueryByTimeDto;

public interface TimeRepoMethods {
    Integer countByTime(QueryByTimeDto queryByTimeDto);
}
