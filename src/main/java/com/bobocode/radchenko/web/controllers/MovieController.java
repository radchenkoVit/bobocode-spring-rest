package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.entity.Movie;
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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getOne(@PathVariable(name = "id") String id) {
        return new Movie();
    }
}
