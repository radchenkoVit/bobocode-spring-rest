package com.bobocode.radchenko.service;

import com.bobocode.radchenko.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(Long id);
    Actor findFullById(Long id);
    void addMovie(Long actorId, Long movieId);
}
