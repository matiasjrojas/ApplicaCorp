package com.challenge.applicacorp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Director implements Comparable<Director> {
    private String name;
    private int movieCount;

    public Director(String name, int movieCount) {
        this.name = name;
        this.movieCount = movieCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Director other) {
        return this.name.compareTo(other.name);
    }
}
