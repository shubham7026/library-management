package com.ind.lms.mappers;

import com.ind.lms.entity.Student;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IMapStudentToStudent {
    Student mapStudentToStudent(Student student);
}
