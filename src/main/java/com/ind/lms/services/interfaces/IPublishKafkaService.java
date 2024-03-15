package com.ind.lms.services.interfaces;

import com.ind.lms.entity.Student;

public interface IPublishKafkaService {
    void publishStudent(Student student);
}
