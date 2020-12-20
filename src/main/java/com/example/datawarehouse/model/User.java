package com.example.datawarehouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private String userId;

    private String profileName;
}
