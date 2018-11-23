package com.jamesdube.unibot.student.service;

import com.jamesdube.unibot.student.business.config.StudentBusinessConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(StudentBusinessConfig.class)
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class,args);
    }
}



