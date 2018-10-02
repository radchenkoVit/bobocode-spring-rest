package com.bobocode.radchenko.dao;

import com.bobocode.radchenko.entity.Actor;

import java.util.List;

public interface ActorDao {
    List<Actor> findAll();
    Actor findById(long id);
    Actor findFullById(long id);
    void save(Actor actor);
    void addMovie(long actorId, long movieId);
}
