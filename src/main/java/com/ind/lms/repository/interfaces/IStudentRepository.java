package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    List<Student> findByFirstName (String name);
}
