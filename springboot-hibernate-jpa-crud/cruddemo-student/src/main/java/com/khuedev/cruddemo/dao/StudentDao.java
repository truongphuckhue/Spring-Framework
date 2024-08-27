package com.khuedev.cruddemo.dao;

import com.khuedev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String lastName);

    void updateStudent(Student student);
    void delete(Integer id);
    int deleteAll();
}
