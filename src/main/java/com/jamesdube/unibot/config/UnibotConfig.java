package com.jamesdube.unibot.config;

import com.jamesdube.unibot.business.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.jamesdube.unibot" })
public class UnibotConfig {

    @Bean
    public PointsService pointsService(){return new PointsService();}

    @Bean
    public DegreeMatcherService degreeMatcherService(){return new DegreeMatcherService();}

    @Bean
    public ClassificationService classificationService(SubjectService subjectService){
        return new ClassificationService(subjectService);
    }
    @Bean
    public SubjectService subjectService(){
        return new SubjectService();
    }

    @Bean
    public RecommendationService recommendationService(SubjectService subjectService, PointsService pointsService, DegreeMatcherService degreeMatcherService, ClassificationService classificationService){
        return new RecommendationService(pointsService, degreeMatcherService, classificationService, subjectService);
    }
}
