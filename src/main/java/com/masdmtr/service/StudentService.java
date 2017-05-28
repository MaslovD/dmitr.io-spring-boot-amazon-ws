package com.masdmtr.service;

import com.masdmtr.dao.StudentDao;
import com.masdmtr.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {

        return this.studentDao.getAllStudents();

    }
    public Student getStudentById(int id) {

        return this.studentDao.getStudentById(id);


    }

    public void removeStudentById(int id) {
        studentDao.removeStudentById(id);
    }

    public void updateStudent (Student student) {

        this.studentDao.updateStudent(student);

    }

    public void insertStudent(Student student) {
        studentDao.inserStudenttoDb (student);
    }
}
