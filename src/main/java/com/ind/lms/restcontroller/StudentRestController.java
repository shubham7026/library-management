package com.ind.lms.restcontroller;


import com.ind.lms.entity.Student;
import com.ind.lms.repository.IStudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
//@RequestMapping("student")
public class StudentRestController {

    private final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    // private  IPricingService iPricingService;

    @Autowired
    private IStudentDAO iCrudRepository;

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        iCrudRepository.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
        iCrudRepository.addStudents(students);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = iCrudRepository.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public List<Student> retrieveAllStudent() {
        return iCrudRepository.findAllStudents();
    }

    @PatchMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student student1 = iCrudRepository.updateStudent(student);
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
        iCrudRepository.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
