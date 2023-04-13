package org.example.repository;

import org.example.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CoursesRepositoryImpl implements CoursesRepository{

   private final EntityManager entityManager;

    public CoursesRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Course entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();

    }
    @Override
    public List<Course> findAllByLessonName(String lessonName) {
         TypedQuery<Course> query = entityManager.createQuery("from Course course", Course.class);
        return query.getResultList();

    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
