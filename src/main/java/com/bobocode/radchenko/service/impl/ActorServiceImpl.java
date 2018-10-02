package com.bobocode.radchenko.service.impl;

import com.bobocode.radchenko.dao.ActorDao;
import com.bobocode.radchenko.entity.Actor;
import com.bobocode.radchenko.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorDao actorDao;

    @Autowired
    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }


    @Override
    public List<Actor> findAll() {
        return null;
    }

    @Override
    public Actor findById(String id) {
        return null;
    }
}
