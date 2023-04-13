package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;
    @Column(length=20)
    private String title;
    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<Student>();
    @OneToMany(mappedBy = "course")
    List<Lesson> lessons = new ArrayList<Lesson>();
    @ManyToOne
    @JoinColumn(name="univer_id")
    private University university;


}
