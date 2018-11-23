package com.jamesdube.unibot.student.business.config;

import com.jamesdube.unibot.student.business.services.StudentService;
import com.jamesdube.unibot.student.business.services.StudentServiceImpl;
import com.jamesdube.unibot.student.repository.api.StudentRepository;
import com.jamesdube.unibot.student.repository.config.StudentRepositoryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StudentRepositoryConfig.class)
public class StudentBusinessConfig {

    @Bean
    StudentService studentService(StudentRepository studentRepository){
        return new StudentServiceImpl(studentRepository);
    }
}
