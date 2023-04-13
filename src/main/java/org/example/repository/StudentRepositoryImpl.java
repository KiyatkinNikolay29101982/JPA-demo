package org.example.repository;

import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentRepositoryImpl implements StudentRepository{

    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(entity);

        transaction.commit();


    }
}
