package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.*;
import com.example.datawarehouse.pojo.MovieInfo;
import com.example.datawarehouse.pojo.NameCount;
import com.example.datawarehouse.pojo.ScoreCount;
import com.example.datawarehouse.service.MovieService;
import com.example.datawarehouse.utils.TimeWrapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mysql")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("analysis/time/year")
    @ResponseBody
    public TimeWrapper<Integer> countByYear(
            @RequestParam("time") String timeStr
    ) {
        return movieService.countByTime(new QueryByTimeDto(TimeGranularity.YEAR, timeStr));
    }

    @GetMapping("analysis/time/season")
    @ResponseBody
    public TimeWrapper<Integer> countBySeason(
            @RequestParam("time") String timeStr
    ) {
        return movieService.countByTime(new QueryByTimeDto(TimeGranularity.SEASON, timeStr));
    }

    @GetMapping("analysis/time/month")
    @ResponseBody
    public TimeWrapper<Integer> countByMonth(
            @RequestParam("time") String timeStr
    ) {
        return movieService.countByTime(new QueryByTimeDto(TimeGranularity.MONTH, timeStr));
    }

    @GetMapping("analysis/time/day")
    @ResponseBody
    public TimeWrapper<Integer> countByDay(
            @RequestParam("time") String timeStr
    ) {
        return movieService.countByTime(new QueryByTimeDto(TimeGranularity.DAY, timeStr));
    }

    @GetMapping("getMovie/title")
    @ResponseBody
    public TimeWrapper<List<MovieInfo>> findByMovieTitle(
            @RequestParam("title") String title,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByMovieTitle(title, limit);
    }

    @GetMapping("getMovie/director")
    @ResponseBody
    public TimeWrapper<List<MovieInfo>> findByDirector(
            @RequestParam("director") String directorName,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByDirector(directorName, limit);
    }

    @GetMapping("getMovie/actor")
    @ResponseBody
    public TimeWrapper<List<MovieInfo>> findByActor(
            @RequestParam("actor") String actorName,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByActor(actorName, limit);
    }

    @GetMapping("getMovie/label")
    public TimeWrapper<List<MovieInfo>> findByLabel(
            @RequestParam("label") String labelName,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByLabel(labelName, limit);
    }

    @GetMapping("getMovie/score")
    @ResponseBody
    public TimeWrapper<List<MovieInfo>> findByScore(
            @RequestParam("value") Double score,
            @RequestParam("comp") String comp,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByScore(new QueryByScoreDto(ScoreType.NORMAL, score, comp, limit));
    }

    @GetMapping("getMovie/emotionScore")
    @ResponseBody
    public TimeWrapper<List<MovieInfo>> findByEmotionScore(
            @RequestParam("value") Double score,
            @RequestParam("comp") String comp,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.findByScore(new QueryByScoreDto(ScoreType.EMOTIONAL, score, comp, limit));
    }

    @GetMapping("getCooperation")
    @ResponseBody
    public TimeWrapper<List<NameCount>> countByCollaborate(
            @RequestParam("type") String relation,
            @RequestParam("name") String name,
            @RequestParam("limit") Integer limit
    ) {
        return movieService.countByCollaborate(new QueryByCollaborateDto(relation, name, limit));
    }

    @GetMapping("analysis/score")
    @ResponseBody
    public TimeWrapper<List<ScoreCount>> countByScore() {
        return movieService.countByScore();
    }

    @GetMapping("analysis/emotionScore")
    @ResponseBody
    public TimeWrapper<List<ScoreCount>> countByEmotionScore() {
        return movieService.countByEmotionScore();
    }

    @GetMapping("analysis/label")
    @ResponseBody
    public TimeWrapper<List<NameCount>> countByLabel(@RequestParam("limit") Integer limit) {
        return movieService.countByLabel(limit);
    }

    @GetMapping("analysis/actor")
    @ResponseBody
    public TimeWrapper<List<NameCount>> countByActor(@RequestParam("limit") Integer limit) {
        return movieService.countByActor(limit);
    }

    @GetMapping("analysis/director")
    @ResponseBody
    public TimeWrapper<List<NameCount>> countByDirector(@RequestParam("limit") Integer limit) {
        return movieService.countByDirector(limit);
    }
}
