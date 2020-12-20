package com.example.datawarehouse.model;

import com.example.datawarehouse.model.pk.LabelMoviePK;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(exclude = { "movie" })
@Entity
public class LabelMovie {

    @EmbeddedId
    private LabelMoviePK id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    @Size(max = 12)
    private Movie movie;

    @Min(0)
    private Integer movieCount;
}
