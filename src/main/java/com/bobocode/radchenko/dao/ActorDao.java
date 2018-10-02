package com.bobocode.radchenko.dao;

import com.bobocode.radchenko.entity.Actor;

import java.util.List;

public interface ActorDao {
    List<Actor> findAll();
    Actor findById(long id);
}
