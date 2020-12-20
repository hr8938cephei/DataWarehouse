package com.example.datawarehouse.model.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class LabelMoviePK implements Serializable {

    private String productId;

    private String labelName;
}
