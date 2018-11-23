package com.jamesdube.unibot.student.repository.config;

import com.jamesdube.unibot.student.domain.models.StudentModelMarker;
import com.jamesdube.unibot.student.repository.api.StudentRepositoryMarker;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration(exclude = {
        JpaRepositoriesAutoConfiguration.class
})
@EnableJpaRepositories(basePackageClasses = {StudentRepositoryMarker.class})
@EntityScan(basePackageClasses = {StudentModelMarker.class})
public class StudentRepositoryConfig {
}
