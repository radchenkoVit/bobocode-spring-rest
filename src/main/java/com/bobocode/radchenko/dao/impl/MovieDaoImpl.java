package com.bobocode.radchenko.dao.impl;

import com.bobocode.radchenko.dao.MovieDao;
import com.bobocode.radchenko.entity.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return em.createQuery("Select m from Movie m", Movie.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Movie findById(long id) {
        return em.find(Movie.class, id);
    }
}
