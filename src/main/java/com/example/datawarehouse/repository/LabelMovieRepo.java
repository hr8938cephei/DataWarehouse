package com.example.datawarehouse.repository;

import com.example.datawarehouse.dto.INameCount;
import com.example.datawarehouse.model.LabelMovie;
import com.example.datawarehouse.model.pk.LabelMoviePK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMovieRepo extends CrudRepository<LabelMovie, LabelMoviePK> {

    @Query(
            value = "select distinct(lm.label_name) name, lm.movie_count total " +
                    "from label_movie lm " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> countByLabelName(@Param("limit") Integer limit);
}
