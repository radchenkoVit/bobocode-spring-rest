package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.entity.Actor;
import com.bobocode.radchenko.entity.Movie;
import com.bobocode.radchenko.exceptions.EntityNotFoundException;
import com.bobocode.radchenko.service.ActorService;
import com.bobocode.radchenko.web.ui.responce.model.ActorDto;
import com.bobocode.radchenko.web.ui.responce.model.FullActorDto;
import com.bobocode.radchenko.web.ui.responce.model.MovieDto;
import com.bobocode.radchenko.web.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;
    private final Validator validator;

    @Autowired
    public ActorController(ActorService actorService, Validator validator) {
        this.actorService = actorService;
        this.validator = validator;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDto> getAll() {
        List<Actor> actorsEntity = actorService.findAll();
        return actorsEntity.stream().map(this::toActorDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActorDto getOne(@PathVariable(name = "id") Long id) {
        return toActorDto(actorService.findById(id));
    }

    @GetMapping("/full/{id}")
    @ResponseStatus(HttpStatus.OK)//TODO: experiment, in another case LAZY EXCEPTION
    public FullActorDto getFullOne(@PathVariable(name = "id") Long id) {
        return toFullActorDto(actorService.findFullById(id));
    }

    //TODO: why not throw exception, or log smth if we call this endpoint with same values twice?
    @GetMapping("/{id}/add/movie")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addMovie(@PathVariable(name = "id") Long actorId, @RequestParam(name = "movieId") Long movieId) {
        if(!validator.isMovieExist(movieId)) {
            throw new EntityNotFoundException(format("Movie with id: %s not found", movieId));
        }
        actorService.addMovie(actorId, movieId);
    }

    //TODO: use mapper instead
    private ActorDto toActorDto(Actor actor) {
        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .build();
    }

    private FullActorDto toFullActorDto(Actor actor) {
        Set<MovieDto> movies = actor.getMovies().stream().map(this::toMovieDto).collect(Collectors.toSet());

        return FullActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .movies(movies)
                .build();
    }

    //TODO: duplication, move to spec package?
    private MovieDto toMovieDto(Movie movie) {
        return MovieDto.builder().id(movie.getId()).name(movie.getName()).build();
    }
}
