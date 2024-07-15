package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IStudentRepository extends MongoRepository<Student, Integer> {
    Student findByEmail(String email);
    List<Student> findByFirstName (String name);
}
