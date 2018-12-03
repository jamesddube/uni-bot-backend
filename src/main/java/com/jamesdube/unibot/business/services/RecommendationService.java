package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.utils.enums.SubjectCategory;
import com.jamesdube.unibot.utils.requests.RecommendationRequest;
import com.jamesdube.unibot.utils.requests.SubjectRequest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.jamesdube.unibot.utils.enums.SubjectCategory.ARTS;
import static com.jamesdube.unibot.utils.enums.SubjectCategory.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.SubjectCategory.SCIENCES;


public class RecommendationService {

    private SubjectService subjectService;

    public RecommendationService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //calculate points

    //calculate category

    public void createRecommendation(RecommendationRequest recommendationRequest){

    }
}
