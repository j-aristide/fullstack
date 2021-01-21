package com.atechsolutions.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentRegistration {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student student;

    @OneToMany
    @JoinTable(name="Student_Registration_Course", joinColumns = @JoinColumn(name = "student_registration_id"),
    inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
