package com.example.datawarehouse.repository;

import com.example.datawarehouse.dto.INameCount;
import com.example.datawarehouse.model.DirectorMovie;
import com.example.datawarehouse.model.pk.DirectorMoviePK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorMovieRepo extends CrudRepository<DirectorMovie, DirectorMoviePK> {

    @Query(
            value = "select dm1.director_name as name, count(dm1.product_id) as total " +
                    "from director_movie dm1 join director_movie dm2 on dm1.product_id = dm2.product_id " +
                    "where dm2.director_name = :directorName and dm1.director_name != :directorName " +
                    "group by dm1.director_name " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> getCollaborateWithDirector(@Param("directorName") String directorName, @Param("limit") Integer limit);

    @Query(
            value = "select dm.director_name as name, count(dm.product_id) as total " +
                    "from director_movie dm join actor_movie am on am.product_id = dm.product_id " +
                    "where am.actor_name = :actorName " +
                    "group by dm.director_name " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> getCollaborateWithActor(@Param("actorName") String actorName, @Param("limit") Integer limit);

    @Query(
            value = "select distinct(dm.director_name) name, dm.movie_count total " +
                    "from director_movie dm " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> countByDirectorName(@Param("limit") Integer limit);
}
