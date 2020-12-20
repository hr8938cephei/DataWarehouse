package com.example.datawarehouse.repository;

import com.example.datawarehouse.dto.INameCount;
import com.example.datawarehouse.model.ActorMovie;
import com.example.datawarehouse.model.pk.ActorMoviePK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorMovieRepo extends CrudRepository<ActorMovie, ActorMoviePK> {

    @Query(
            value = "select am.actor_name as name, count(am.product_id) as total " +
                    "from actor_movie am join director_movie dm on am.product_id = dm.product_id " +
                    "where dm.director_name = :directorName " +
                    "group by am.actor_name " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> getCollaborateWithDirector(@Param("directorName") String directorName, @Param("limit") Integer limit);

    @Query(
            value = "select am1.actor_name as name, count(am1.product_id) as total " +
                    "from actor_movie am1 join actor_movie am2 on am1.product_id = am2.product_id " +
                    "where am2.actor_name = :actorName and am1.actor_name != :actorName " +
                    "group by am1.actor_name " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> getCollaborateWithActor(@Param("actorName") String actorName, @Param("limit") Integer limit);

    @Query(
            value = "select distinct(am.actor_name) name, am.movie_count total " +
                    "from actor_movie am " +
                    "order by total desc " +
                    "limit :limit",
            nativeQuery = true
    )
    List<INameCount> countByActorName(@Param("limit") Integer limit);
}
