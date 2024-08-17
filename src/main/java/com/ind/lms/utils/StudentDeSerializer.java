package com.ind.lms.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ind.lms.entity.Student;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class StudentDeSerializer implements Deserializer<Student> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Student deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), Student.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }
}
