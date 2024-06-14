package com.challenge.applicacorp.controller;

import com.challenge.applicacorp.model.Director;
import com.challenge.applicacorp.service.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/api/directors")
    public List<Director> getDirectors(@RequestParam int threshold) {
        return directorService.getDirectorsAboveThreshold(threshold);
    }
}
