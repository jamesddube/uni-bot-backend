package com.jamesdube.unibot.config;

import com.jamesdube.unibot.business.services.*;
import com.jamesdube.unibot.repository.DegreeRepository;
import com.jamesdube.unibot.repository.SubjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.jamesdube.unibot" })
public class UnibotConfig {

    @Bean
    public PointsService pointsService(){return new PointsService();}

    @Bean
    public DegreeMatcherService degreeMatcherService(DegreeRepository degreeRepository){
        return new DegreeMatcherService(degreeRepository);}

    @Bean
    public ClassificationService classificationService(SubjectService subjectService){
        return new ClassificationService(subjectService);
    }
    @Bean
    public SubjectService subjectService(SubjectRepository subjectRepository){
        return new SubjectService(subjectRepository);
    }

    @Bean
    public RecommendationService recommendationService(SubjectService subjectService, PointsService pointsService, DegreeMatcherService degreeMatcherService, ClassificationService classificationService){
        return new RecommendationService(pointsService, degreeMatcherService, classificationService, subjectService);
    }
}
