package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    Long id;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "student_id", referencedColumnName ="id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    List<Course> courses = new ArrayList<Course>();

}
