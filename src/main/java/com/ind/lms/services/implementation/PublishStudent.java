package com.ind.lms.services.implementation;

import com.ind.lms.constants.Constants;
import com.ind.lms.entity.Student;
import com.ind.lms.services.interfaces.IPublishKafkaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PublishStudent implements IPublishKafkaService {

    @Autowired
    KafkaProducer<String, Student> producer;

    @Override
    public void publishStudent(Student student) {
        producer.send(new ProducerRecord<>(Constants.CREATE_STUDENT_TOPIC, String.valueOf(student.getId()), student));
        log.info("Message Sent - {}", student);
        producer.close();
    }
}
