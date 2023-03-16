package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    private List<StudentCourse> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(new StudentCourse(this, course));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentCourse> getCourses() {
        return courses;
    }
}
