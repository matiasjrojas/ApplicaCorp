package com.challenge.applicacorp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Movie {
    private String title;
    private String director;
    private LocalDate releaseDate;

    public Movie() {}

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("Director")
    public void setDirector(String director) {
        this.director = director;
    }

    @JsonProperty("Released")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("Released")
    public void setReleaseDate(String released) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        this.releaseDate = LocalDate.parse(released, formatter);
    }
}