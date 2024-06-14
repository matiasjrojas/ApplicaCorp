package com.challenge.applicacorp.service;

import com.challenge.applicacorp.model.Movie;
import com.challenge.applicacorp.model.MovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static final String API_URL = "https://directa24-movies.wiremockapi.cloud/api/movies/search?page=";
    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> fetchAllMovies() {
        List<Movie> movies = new ArrayList<>();
        int page = 1;
        MovieResponse response;

        do {
            String url = API_URL + page;
            response = restTemplate.getForObject(url, MovieResponse.class);

            if (response != null && response.getData() != null) {
                for (Movie movie : response.getData()) {
                    movies.add(movie);
                }
            }
            page++;
        } while (response != null && page <= response.getTotalPages());

        return movies;
    }
}
