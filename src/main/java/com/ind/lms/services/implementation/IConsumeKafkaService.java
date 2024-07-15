package com.ind.lms.services.implementation;

import com.ind.lms.constants.Constants;
import com.ind.lms.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class IConsumeKafkaService {

    @Autowired
    private KafkaConsumer<String, Student> consumer;


    /*@KafkaListener(topics = {"create_student"}, groupId = "1")
    public void consumeStudent(@Payload Object student, ConsumerRecord<String,Student> consumer){

        AtomicReference<Student> msgCons = new AtomicReference<>();

        AtomicReference<Student> student = null;

        consumer.subscribe(Arrays.asList(Constants.CREATE_STUDENT_TOPIC));

        ConsumerRecords<String, Student> records = consumer.poll(Duration.ofSeconds(1));
        records.forEach(record -> {
            student.set(record.value());
            System.out.println("Message received " + student);
        });

        consumer.close();

        //log.info("Message consumed - {}",consumer.value());
        //Student student =(Student) consumer.value();
        log.info("Student Event received - {}",student);

    }*/
}
