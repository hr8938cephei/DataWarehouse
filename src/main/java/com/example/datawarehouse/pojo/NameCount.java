package com.example.datawarehouse.pojo;

import com.example.datawarehouse.dto.INameCount;
import lombok.Data;

@Data
public class NameCount {

    private final String name;

    private final Integer count;

    public NameCount(INameCount iNameCount) {
        this.name = iNameCount.getName();
        this.count = iNameCount.getTotal();
    }
}
