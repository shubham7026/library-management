package com.ind.lms;

import com.ind.lms.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LmsApplication {

	private final Logger logger = LoggerFactory.getLogger(LmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
		/*ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");

		//System.out.println(person);

		ConfigurableListableBeanFactory factory = ctx.getBeanFactory();
		factory.registerSingleton("person",new Person());

		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);*/

	}


	/*@Override
	public void run(String... args) throws Exception {
		logger.info("--LmsApplication---");
	}*/
}
