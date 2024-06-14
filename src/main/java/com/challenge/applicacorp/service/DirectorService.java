package com.challenge.applicacorp.service;

import com.challenge.applicacorp.model.Director;
import com.challenge.applicacorp.model.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    private final MovieService movieService;

    public DirectorService(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Director> getDirectorsAboveThreshold(int threshold) {
        List<Movie> movies = movieService.fetchAllMovies();
        Map<String, Integer> directorCountMap = new HashMap<>();

        for (Movie movie : movies) {
            directorCountMap.put(movie.getDirector(), directorCountMap.getOrDefault(movie.getDirector(), 0) + 1);
        }

        return directorCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(entry -> new Director(entry.getKey(), entry.getValue()))
                .sorted()
                .collect(Collectors.toList());
    }
}

