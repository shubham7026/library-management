package com.ind.lms.config;


import com.ind.lms.repository.IStudentDAO;
import com.ind.lms.repository.StudentDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class RequiredConfiguration {
    @Bean
    public IStudentDAO crudRepository(){
        return new StudentDAO() ;
    }
}
