package com.ind.lms.config;

import com.ind.lms.entity.Student;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Properties;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("create_student").build();
    }

    @Bean
    public KafkaProducer<String, Student> createKafkaProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.ind.lms.utils.StudentSerializer");

        return new KafkaProducer<>(props);
    }



    @Bean
    public KafkaConsumer<String,Student> createKafkaConsumer(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG ,"com.ind.lms.utils.StudentDeSerializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
        return new KafkaConsumer<>(props);
    }

}
