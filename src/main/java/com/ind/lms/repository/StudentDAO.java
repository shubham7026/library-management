package com.ind.lms.repository;

import com.ind.lms.customexceptions.StudentNotFoundException;
import com.ind.lms.entity.Student;
import com.ind.lms.mappers.IMapStudentToStudent;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO implements IStudentDAO {

    @Autowired
    private IMapStudentToStudent mapStudentToStudent;
    private final Logger logger = LoggerFactory.getLogger(StudentDAO.class);

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addStudent(Student student) {
        logger.debug("Adding Student resource- {}", student);
        entityManager.persist(student);
        logger.debug("Student resource added successfully- {}", student);
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
        logger.debug("updating Student resource with ID - {}", id);
        Student retrievedStudent = getStudent(id);
        if (retrievedStudent == null) {
            return null;
        }
        Student updatedStudent = entityManager.merge(student);
        logger.debug("Student resource updated successfully- {}", updatedStudent);
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
        logger.debug("Getting Student with - {}", id);
        Student retrievedStudent = null ;
        try {
            retrievedStudent = entityManager.find(Student.class, id);
            if (retrievedStudent == null)
                throw new StudentNotFoundException("Student not found with id - " + id);

        } catch (Exception e) {
            logger.error("Student not found with id - {}", id);
            throw e;
        }

        logger.debug("Retrieved Student with id - {}, {}", retrievedStudent.getId(), retrievedStudent);
        return retrievedStudent;
    }

    @Override
    public List<Student> findAllStudents() {
        logger.debug("Getting All Student");
        List<Student> students = entityManager.createQuery("From Student", Student.class).getResultList();
        logger.debug("Retrieved All Student - {}", students);
        return students;
    }
}
