package org.example.repository;



import org.example.entity.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LessonRepositoryImpl implements LessonsRepository{

    private final EntityManager entityManager;

    public LessonRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public void save(Lesson entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(entity);

        transaction.commit();

    }
}
