package com.ind.lms.services.interfaces;

import com.ind.lms.entity.Student;

import java.util.List;

public interface IStudentApplicationService {

    Student addStudent(Student student);
    Student getStudentById(int id);

    List<Student> getAllStudents();
    Student getStudentByEmail(String email);
    List<Student> getStudentByName(String name);

    void addBookToStudent(int id, int isbn);
}
