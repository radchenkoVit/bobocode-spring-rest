package com.bobocode.radchenko.dao;

import com.bobocode.radchenko.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
    Movie findById(long id);
}
