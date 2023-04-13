package demo;

import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.entity.Student;
import org.example.entity.University;
import org.example.repository.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        CoursesRepository coursesRepository = new CoursesRepositoryImpl(entityManager);
        LessonsRepository lessonsRepository = new LessonRepositoryImpl(entityManager);
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);
        UniversityRepository universityRepository = new UniversityRepositoryImpl(entityManager);

        University university = University.builder()
                .name("SamGMU")
                .build();

        universityRepository.save(university);

        Course java = Course.builder()
                .title("java")
                .university(university)
                .build();

        Course sql = Course.builder()
                .university(university)
                .title("SQL")
                .build();
        coursesRepository.save(java);
        coursesRepository.save(sql);

        Lesson spring = Lesson.builder()
                .name("Spring")
                .course(java)
                .build();

        Lesson jvm = Lesson.builder()
                .name("JVM")
                .course(java)
                .build();

       Lesson jdbc= Lesson.builder()
                .name("JDBC")
                .course(java)
                .build();

      Lesson index= Lesson.builder()
               .name("index")
                .course(sql)
                .build();

        Lesson select= Lesson.builder()
                .name("Select")
                .course(sql)
                .build();

        Lesson update= Lesson.builder()
                .name("Update")
                .course(sql)
                .build();

        List<Course> list = new ArrayList<Course>();
        list.add(java);
        list.add(sql);

        Student ivan = Student.builder()
                .firstName("ivan")
                .lastName("Ivanov")
                .courses(list)
                .build();

        Student regina = Student.builder()
                .firstName("Regina")
               .lastName("Valeeva")
                .courses(Arrays.asList(java, sql))
                .build();


        lessonsRepository.save(spring);
        lessonsRepository.save(jdbc);
        lessonsRepository.save(jvm);

        lessonsRepository.save(index);
        lessonsRepository.save(select);
        lessonsRepository.save(update);

        studentRepository.save(ivan);
        studentRepository.save(regina);
    }
}
