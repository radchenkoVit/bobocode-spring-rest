package com.bobocode.radchenko.web.ui.responce.model;

import java.util.Set;

//TODO: delete, just experiment
public class FullActorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<MovieDto> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieDto> movies) {
        this.movies = movies;
    }
}
