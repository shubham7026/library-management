package com.ind.lms.restcontroller;


import com.ind.lms.customexceptions.StudentNotFoundException;
import com.ind.lms.entity.Student;
import com.ind.lms.services.interfaces.IStudentApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController(value = "StudentRestController")
@AllArgsConstructor
@Slf4j
public class StudentRestController {

    private final IStudentApplicationService studentApplicationService;


    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student  addedStudent = studentApplicationService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Student student = studentApplicationService.getStudentById(id);
        if (student == null){
            log.error("Student not found with Id - {}",id);
            throw new StudentNotFoundException("Student not found with Id - " + id);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/student",params = "email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam("email") String email) {
        Student student = studentApplicationService.getStudentByEmail(email);
        if (student == null){
            log.error("Student not found with Email - {}",email);
            throw new StudentNotFoundException("Student not found with Id " + email);
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/student", params = "firstName")
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam("firstName") String firstName) {
        List<Student> students = studentApplicationService.getStudentByName(firstName);
        if (students == null || students.isEmpty()){
            log.error("Student not found with FirstName - {}",firstName);
            throw new StudentNotFoundException("Student not found with Id " + firstName);
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> retrieveAllStudent() {
        List<Student> students = studentApplicationService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity addBookToStudent(@PathVariable("id") int id, @RequestBody int isbn){
        studentApplicationService.addBookToStudent(id, isbn);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
