package com.example.datawarehouse.repository;

import com.example.datawarehouse.model.Time;
import com.example.datawarehouse.repository.repoMethods.TimeRepoMethods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepo extends CrudRepository<Time, Long>, TimeRepoMethods {

//    @Procedure("countByYear")
//    Integer countByYear(Integer year, String operator);
//
//    @Procedure("countByMonth")
//    Integer countByMonth(Integer year, Integer month, String operator);
//
//    @Procedure("countByDay")
//    Integer countByDay(Integer year, Integer month, Integer day, String operator);

//    @Query("select sum(t.dayCount) " +
//           "from Time t " +
//           "where (t.year > :startYear or (t.year = :startYear and t.month > :startMonth) or (t.year = :startYear and t.month = :startMonth and t.day >= :startDay)) " +
//           "and (t.year < :endYear) or (t.year = :endYear and t.month < :endMonth) or (t.year = :endYear and t.month = :endMonth and t.day <= :endDay)"
//    )
//    Integer countByTime(
//            @Param("startYear") Integer startYear,
//            @Param("startMonth") Integer startMonth,
//            @Param("startDay") Integer startDay,
//            @Param("endYear") Integer endYear,
//            @Param("endMonth") Integer endMonth,
//            @Param("endDay") Integer endDay
//    );

    @Query(
            value = "select t.year_count from time t where t.year = :year limit 1",
            nativeQuery = true
    )
    Integer countByYear(@Param("year") Integer year);

    @Query(
            value = "select t.season_count from time t where t.year = :year and t.season = :season limit 1",
            nativeQuery = true
    )
    Integer countBySeason(@Param("year") Integer year, @Param("season") Integer season);

    @Query(
            value = "select t.month_count from time t where t.year = :year and t.month = :month limit 1",
            nativeQuery = true
    )
    Integer countByMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Query(
            value = "select t.day_count from time t where t.year = :year and t.month = :month and t.day = :day",
            nativeQuery = true
    )
    Integer countByDay(@Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day);
}
