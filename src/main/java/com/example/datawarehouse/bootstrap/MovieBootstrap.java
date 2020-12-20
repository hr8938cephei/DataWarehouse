package com.example.datawarehouse.bootstrap;

import com.example.datawarehouse.dto.*;
import com.example.datawarehouse.model.Movie;
import com.example.datawarehouse.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Profile({ "mysql" })
public class MovieBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TimeRepo timeRepo;

    private final MovieRepo movieRepo;

    private final ActorMovieRepo actorMovieRepo;

    private final DirectorMovieRepo directorMovieRepo;

    private final LabelMovieRepo labelMovieRepo;

    private final EmotionScoreRepo emotionScoreRepo;

    private final ScoreRepo scoreRepo;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        Integer count = timeRepo.countByTime(2002, 2, 20, 2021, 1, 1);
//
//        System.out.println("count: " + count);

//        List<Movie> movies = movieRepo.findByLabelName("20th Century Fox Home Entertainment", 5);
//        System.out.println(movies);
    }
}
