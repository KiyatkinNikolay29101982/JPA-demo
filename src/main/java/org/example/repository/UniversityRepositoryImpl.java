package org.example.repository;

import org.example.entity.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UniversityRepositoryImpl implements UniversityRepository {
    private final EntityManager entityManager;

    public UniversityRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(University entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(entity);

        transaction.commit();
    }
}
