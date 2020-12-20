package com.example.datawarehouse.model;

import com.example.datawarehouse.model.pk.LabelMoviePK;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = { "movie" })
@Entity
public class LabelMovie {

    @EmbeddedId
    private LabelMoviePK id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private Movie movie;

    private Integer movieCount;
}
