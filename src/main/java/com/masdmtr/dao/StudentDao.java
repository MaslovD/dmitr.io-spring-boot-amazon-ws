package com.masdmtr.dao;

import com.masdmtr.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void inserStudenttoDb(Student student);
}
