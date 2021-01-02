package com.example.datawarehouse.service;

import com.example.datawarehouse.dto.*;
import com.example.datawarehouse.model.EmotionScore;
import com.example.datawarehouse.model.Movie;
import com.example.datawarehouse.model.Score;
import com.example.datawarehouse.model.Time;
import com.example.datawarehouse.pojo.MovieInfo;
import com.example.datawarehouse.pojo.NameCount;
import com.example.datawarehouse.pojo.ScoreCount;
import com.example.datawarehouse.repository.*;
import com.example.datawarehouse.utils.TimeAccumulator;
import com.example.datawarehouse.utils.TimeWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final ActorMovieRepo actorMovieRepo;

    private final DirectorMovieRepo directorMovieRepo;

    private final LabelMovieRepo labelMovieRepo;

    private final EmotionScoreRepo emotionScoreRepo;

    private final ScoreRepo scoreRepo;

    private final MovieRepo movieRepo;

    private final TimeRepo timeRepo;

    public TimeWrapper<Integer> countByTime(QueryByTimeDto queryByTimeDto) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        Integer count = timeRepo.countByTime(queryByTimeDto);
        timeAccumulator.stop();
        return new TimeWrapper<>(count, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<MovieInfo>> findByMovieTitle(String title, Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Movie> movieList = movieRepo.findByTitle(title, limit);
        timeAccumulator.stop();
        List<MovieInfo> movieInfoList = movieList.stream().map(MovieInfo::new).collect(Collectors.toList());
        return new TimeWrapper<>(movieInfoList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<MovieInfo>> findByDirector(String directorName, Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Movie> movieList = movieRepo.findByDirectorName(directorName, limit);
        timeAccumulator.stop();
        List<MovieInfo> movieInfoList = movieList.stream().map(MovieInfo::new).collect(Collectors.toList());
        return new TimeWrapper<>(movieInfoList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<MovieInfo>> findByActor(String actorName, Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Movie> movieList = movieRepo.findByActorName(actorName, limit);
        timeAccumulator.stop();
        List<MovieInfo> movieInfoList = movieList.stream().map(MovieInfo::new).collect(Collectors.toList());
        return new TimeWrapper<>(movieInfoList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<MovieInfo>> findByLabel(String labelName, Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Movie> movieList = movieRepo.findByLabelName(labelName, limit);
        timeAccumulator.stop();
        List<MovieInfo> movieInfoList = movieList.stream().map(MovieInfo::new).collect(Collectors.toList());
        return new TimeWrapper<>(movieInfoList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<MovieInfo>> findByScore(QueryByScoreDto queryByScoreDto) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Movie> movieList = movieRepo.findByScore(queryByScoreDto);
        timeAccumulator.stop();
        List<MovieInfo> movieInfoList = movieList.stream().map(MovieInfo::new).collect(Collectors.toList());
        return new TimeWrapper<>(movieInfoList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<NameCount>> countByCollaborate(QueryByCollaborateDto queryByCollaborateDto) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        List<INameCount> iNameCountList;
        timeAccumulator.start();
        if (queryByCollaborateDto.getRole1() == Role.ACTOR) {
            if (queryByCollaborateDto.getRole2() == Role.DIRECTOR) {
                iNameCountList = directorMovieRepo.getCollaborateWithActor(queryByCollaborateDto.getName(), queryByCollaborateDto.getLimit());
            } else {
                iNameCountList = actorMovieRepo.getCollaborateWithActor(queryByCollaborateDto.getName(), queryByCollaborateDto.getLimit());
            }
        } else {
            if (queryByCollaborateDto.getRole2() == Role.ACTOR) {
                iNameCountList = actorMovieRepo.getCollaborateWithDirector(queryByCollaborateDto.getName(), queryByCollaborateDto.getLimit());
            } else {
                iNameCountList = directorMovieRepo.getCollaborateWithDirector(queryByCollaborateDto.getName(), queryByCollaborateDto.getLimit());
            }
        }
        timeAccumulator.stop();
        List<NameCount> nameCountList = iNameCountList.stream().map(NameCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(nameCountList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<ScoreCount>> countByScore() {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<Score> scoreList = scoreRepo.findAll();
        timeAccumulator.stop();
        List<ScoreCount> scoreCountList = scoreList.stream().map(ScoreCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(scoreCountList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<ScoreCount>> countByEmotionScore() {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<EmotionScore> scoreList = emotionScoreRepo.findAll();
        timeAccumulator.stop();
        List<ScoreCount> scoreCountList = scoreList.stream().map(ScoreCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(scoreCountList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<NameCount>> countByActor(Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<INameCount> iNameCountList = actorMovieRepo.countByActorName(limit);
        timeAccumulator.stop();
        List<NameCount> nameCountList = iNameCountList.stream().map(NameCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(nameCountList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<NameCount>> countByDirector(Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<INameCount> iNameCountList = directorMovieRepo.countByDirectorName(limit);
        timeAccumulator.stop();
        List<NameCount> nameCountList = iNameCountList.stream().map(NameCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(nameCountList, timeAccumulator.getTotalTime());
    }

    public TimeWrapper<List<NameCount>> countByLabel(Integer limit) {
        TimeAccumulator timeAccumulator = new TimeAccumulator();
        timeAccumulator.start();
        List<INameCount> iNameCountList = labelMovieRepo.countByLabelName(limit);
        timeAccumulator.stop();
        List<NameCount> nameCountList = iNameCountList.stream().map(NameCount::new).collect(Collectors.toList());
        return new TimeWrapper<>(nameCountList, timeAccumulator.getTotalTime());
    }
}
