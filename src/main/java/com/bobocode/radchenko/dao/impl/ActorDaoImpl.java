package com.bobocode.radchenko.dao.impl;

import com.bobocode.radchenko.dao.ActorDao;
import com.bobocode.radchenko.entity.Actor;
import com.bobocode.radchenko.entity.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActorDaoImpl implements ActorDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Actor> findAll() {
        return em.createQuery("Select a from Actor a", Actor.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Actor findById(long id) {
        return em.find(Actor.class, id);
    }

    @Transactional(readOnly = true)
    public Actor findFullById(long id) {
        return em.createQuery("Select a from Actor a join fetch a.movies where a.id = :id", Actor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    //TODO: here not reurn managed Actor object
    public void save(Actor actor) {
        em.persist(actor);
    }

    @Override
    public void addMovie(long actorId, long movieId) {
        Actor actor = em.find(Actor.class, actorId);
        Movie movie = em.getReference(Movie.class, movieId);
        actor.addMovie(movie);
    }
}
