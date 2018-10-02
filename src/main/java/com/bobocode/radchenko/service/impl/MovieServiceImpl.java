package com.bobocode.radchenko.service.impl;

import com.bobocode.radchenko.dao.MovieDao;
import com.bobocode.radchenko.entity.Movie;
import com.bobocode.radchenko.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findById(String id) {
        return null;
    }
}
