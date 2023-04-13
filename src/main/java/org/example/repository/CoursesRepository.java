package org.example.repository;

import org.example.entity.Course;

import java.util.List;

public interface CoursesRepository extends CRUDRepository<Course>{
    List<Course> findAllByLessonName(String lessonName);

    List<Course> findAll();
}
