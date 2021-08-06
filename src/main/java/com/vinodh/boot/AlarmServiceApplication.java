package com.vinodh.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.vinodh.*")
@EntityScan("com.vinodh.model")	
@EnableJpaRepositories(basePackages = "com.vinodh.repository", entityManagerFactoryRef="jpaEntityManagerFactoryBean")
public class AlarmServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(AlarmServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AlarmServiceApplication.class, args);
		log.info("AdvancedSearchApplication started successfully...");
	}

}
