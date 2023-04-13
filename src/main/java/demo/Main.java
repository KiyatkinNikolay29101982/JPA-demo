package demo;

import org.example.entity.Student;
import org.example.repository.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        CoursesRepository coursesRepository = new CoursesRepositoryImpl(entityManager);
        LessonsRepository lessonsRepository = new LessonRepositoryImpl(entityManager);
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Student student = entityManager.find(Student.class, 2L);
        Student student1 = entityManager.find(Student.class, 3L);
        Student student2= entityManager.find(Student.class, 4L);

        entityManager.refresh(student1);


        transaction.commit();


    }
}
