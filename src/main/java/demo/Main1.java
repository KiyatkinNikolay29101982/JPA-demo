package demo;

import org.example.dto.CourseStat;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.repository.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class Main1 {
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

        TypedQuery<CourseStat> query = entityManager.createQuery("select new org.example.dto.CourseStat(course.title, " +
                "course.lessons.size, course.students.size) from Course course where course.id = 1", CourseStat.class);
        CourseStat courseStat = query.getSingleResult();

        System.out.println(courseStat);


        transaction.commit();

    }
}
