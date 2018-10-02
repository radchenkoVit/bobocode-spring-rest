package com.bobocode.radchenko.dao.impl;

import com.bobocode.radchenko.dao.ActorDao;
import com.bobocode.radchenko.entity.Actor;
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
        return em.createQuery("Select a from Actor a").getResultList();
    }

    @Transactional(readOnly = true)
    public Actor findById(long id) {
        return em.find(Actor.class, id);
    }
}
