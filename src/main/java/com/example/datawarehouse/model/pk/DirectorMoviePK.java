package com.example.datawarehouse.model.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class DirectorMoviePK implements Serializable {

    private String productId;

    private String directorName;
}
