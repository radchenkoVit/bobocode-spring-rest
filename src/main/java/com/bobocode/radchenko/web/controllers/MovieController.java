package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.entity.Movie;
import com.bobocode.radchenko.service.MovieService;
import com.bobocode.radchenko.web.ui.responce.model.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Movie> moviesEntity = movieService.findAll();
        return moviesEntity.stream().map(this::toMovieDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDto getOne(@PathVariable(name = "id") Long id) {
        return toMovieDto(movieService.findById(id));
    }

    private MovieDto toMovieDto(Movie movie) {
        return MovieDto.builder().id(movie.getId()).name(movie.getName()).build();
    }
}
