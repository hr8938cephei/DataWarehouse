package com.example.datawarehouse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class User {

    @Id
    @Column(length = 16)
    @Size(max = 16)
    private String userId;

    private String profileName;
}
