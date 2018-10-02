package com.bobocode.radchenko.service;

import com.bobocode.radchenko.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(String id);
}
