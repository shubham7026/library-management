package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void addStudent(Student student);
    void addStudents(List<Student> students);
    Student updateStudent(Student student);
    void deleteStudent(int id);
    Student getStudent(int id);

    List<Student> findAllStudents();

}
