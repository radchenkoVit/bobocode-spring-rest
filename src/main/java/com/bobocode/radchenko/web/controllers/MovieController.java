package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.service.MovieService;
import com.bobocode.radchenko.web.ui.responce.model.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDto> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDto getOne(@PathVariable(name = "id") String id) {
        return new MovieDto();
    }
}
