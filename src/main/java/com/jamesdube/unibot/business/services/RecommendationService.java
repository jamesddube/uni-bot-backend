package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.requests.RecommendationRequest;
import com.jamesdube.unibot.utils.requests.SubjectRequest;
import com.jamesdube.unibot.utils.response.RecommendationResponse;

import java.util.List;

public class RecommendationService {

    private PointsService pointsService;

    private DegreeMatcherService degreeMatcherService;

    private ClassificationService classificationService;

    private SubjectService subjectService;

    public RecommendationService(PointsService pointsService, DegreeMatcherService degreeMatcherService, ClassificationService classificationService, SubjectService subjectService) {
        this.pointsService = pointsService;
        this.degreeMatcherService = degreeMatcherService;
        this.classificationService = classificationService;
        this.subjectService = subjectService;
    }

    //calculate points

    //calculate category

    public RecommendationResponse createRecommendation(RecommendationRequest recommendationRequest){

        RecommendationResponse response = new RecommendationResponse();

        List<SubjectRequest> subjectRequests = recommendationRequest.getSubjectRequests();

        int points = pointsService.calculatePoints(subjectRequests);

        Classification classification = classificationService.calculateCategory(subjectRequests);

        List<Degree> degrees = degreeMatcherService.getDegrees(classification,points);

        response.setPoints(points);
        response.setClassification(classification);
        response.setDegrees(degrees);

        return response;

    }
}
