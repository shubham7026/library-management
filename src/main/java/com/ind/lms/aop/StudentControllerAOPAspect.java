package com.ind.lms.aop;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class StudentControllerAOPAspect {

    private final Logger logger = LoggerFactory.getLogger(StudentControllerAOPAspect.class);
    @Pointcut("execution( void  com.ind.lms.restcontroller.StudentRestController.addStudent(..) )")
    public void studentController(){
            logger.info("inside pointcut");

    }
}
