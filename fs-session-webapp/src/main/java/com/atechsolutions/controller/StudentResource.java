package com.atechsolutions.controller;

import com.atechsolutions.model.Student;
import com.atechsolutions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentResource {
    @Autowired
    private StudentRepository repository;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        repository.deleteById(id);
    }
}
