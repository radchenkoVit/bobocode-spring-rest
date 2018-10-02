package com.bobocode.radchenko.web.validator;

import com.bobocode.radchenko.dao.ActorDao;
import com.bobocode.radchenko.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    private final ActorDao actorDao;
    private final MovieDao movieDao;

    @Autowired
    public Validator(ActorDao actorDao, MovieDao movieDao) {
        this.actorDao = actorDao;
        this.movieDao = movieDao;
    }

    //TODO: to refactor --> should possible to check from Dao
    public boolean isMovieExist(Long id) {
        if (movieDao.findById(id) == null) {
            return false;
        }
        return true;
    }
}
