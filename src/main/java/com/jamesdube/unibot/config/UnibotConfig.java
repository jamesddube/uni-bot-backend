package com.jamesdube.unibot.config;

import com.jamesdube.unibot.business.services.RecommendationService;
import com.jamesdube.unibot.business.services.SubjectService;
import com.jamesdube.unibot.domain.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnibotConfig {

    @Bean
    public SubjectService subjectService(){
        return new SubjectService();
    }

    @Bean
    public RecommendationService recommendationService(SubjectService subjectService){
        return new RecommendationService(subjectService);
    }
}
