package com.bellintegrator.firstTask.citizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CitizenshipDaoImpl implements CitizenshipDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Citizenship> findAll() {
        TypedQuery<Citizenship> query = entityManager.createQuery("SELECT c FROM Citizenship c", Citizenship.class);
        return query.getResultList();
    }
}
