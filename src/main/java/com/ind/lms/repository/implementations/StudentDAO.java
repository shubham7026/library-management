package com.ind.lms.repository.implementations;

import com.ind.lms.customexceptions.StudentNotFoundException;
import com.ind.lms.entity.Student;
import com.ind.lms.repository.interfaces.IStudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Component
public class StudentDAO implements IStudentDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void addStudent(Student student) {
        log.debug("Adding Student resource : {}", student);
        entityManager.persist(student);
        log.debug("Student resource added successfully : {}", student);
    }

    @Override
    @Transactional
    public void addStudents(List<Student> students){
        students.forEach(this::addStudent);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {

        int id = student.getId();
        log.debug("updating Student resource with ID - {}", id);
        Student retrievedStudent = getStudent(id);
        Student updatedStudent = entityManager.merge(student);
        log.debug("Student resource updated successfully- {}", updatedStudent);
        return updatedStudent;

    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = getStudent(id);
        entityManager.remove(student);
    }

    @Override
    public Student getStudent(int id) {
        log.debug("Getting Student with - {}", id);
        Student retrievedStudent = null ;
        try {
            retrievedStudent = entityManager.find(Student.class, id);
            if (retrievedStudent == null)
                throw new StudentNotFoundException("Student not found with id - " + id);

        } catch (Exception e) {
            log.error("Student not found with id - {}", id);
            throw e;
        }

        log.debug("Retrieved Student with id - {}, {}", retrievedStudent.getId(), retrievedStudent);
        return retrievedStudent;
    }

    @Override
    public List<Student> findAllStudents() {
        log.debug("Getting All Student");
        List<Student> students = entityManager.createQuery("From Student", Student.class).getResultList();
        log.debug("Retrieved All Student - {}", students);
        return students;
    }
}
