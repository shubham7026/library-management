package com.ind.lms.config;

import com.ind.lms.mappers.IMapStudentToStudent;
import com.ind.lms.mappers.IMapStudentToStudentImpl;
import org.springframework.context.annotation.Bean;

public class MapperConfig {
    @Bean
    public IMapStudentToStudent mapStudentToStudent(){
        return new IMapStudentToStudentImpl();
    }


}
