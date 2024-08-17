package com.ind.lms.services.implementation;


import com.ind.lms.entity.Student;
import com.ind.lms.repository.interfaces.IStudentRepository;
import com.ind.lms.services.interfaces.IPublishKafkaService;
import com.ind.lms.services.interfaces.IStudentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor

public class StudentApplicationService implements IStudentApplicationService {
    private final IStudentRepository iStudentRepository;
    private final IPublishKafkaService iPublishKafkaService;

    public Student addStudent(Student student){
        log.debug("Adding Student : {}", student);

        Student studentFoundWIthEmail = getStudentByEmail(student);
        if (Objects.nonNull(studentFoundWIthEmail)){
            log.debug("Student already Exist");
            return studentFoundWIthEmail;
        }
        student.setId((int)(Math.random()*100));

        Student  savedStudent = iStudentRepository.save(student);
        log.debug("Student saved with id : {}",student.getId());

        iPublishKafkaService.publishStudent(savedStudent);

        return savedStudent ;
    }

    public Student getStudentById(int id){
        log.debug("Getting Student with id - {}",id);

        Optional<Student> retrievedStudent = iStudentRepository.findById(id);

        retrievedStudent.ifPresentOrElse(student -> log.debug("Student found with id : {}",student), () -> log.debug("Student not found"));

        return retrievedStudent.orElse(null);

    }

    @Override
    public List<Student> getAllStudents() {
        log.debug("Getting Students");
        List<Student> students = new ArrayList<>(iStudentRepository.findAll());
        log.debug("Students found - {}",students);
        return students;
    }

    @Override
    public Student getStudentByEmail(String email) {

        Student tempStudent = new Student();
        tempStudent.setEmail(email);
       return getStudentByEmail(tempStudent);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        log.debug("Getting Student by name - {}",name);

        List<Student> fetchedStudents = iStudentRepository.findByFirstName(name);

        if (Objects.isNull(fetchedStudents) && fetchedStudents.isEmpty()) return null;

        log.debug("Students found by name - {}",fetchedStudents);
        return fetchedStudents;
    }

    @Override
    public void addBookToStudent(int id, int isbn) {
        Student student = getStudentById(id);

        if (student.getIsbn() != isbn){
            student.setIsbn(isbn);
        }
    }

    private Student getStudentByEmail(Student student){
        log.debug("Getting Student by Email - {}",student.getEmail());

        Student fetchedStudent = iStudentRepository.findByEmail(student.getEmail());

        if (Objects.isNull(fetchedStudent)) return null;

        log.debug("Student found by Email - {} : {}",fetchedStudent.getEmail(),student);
        return fetchedStudent;
    }
}
