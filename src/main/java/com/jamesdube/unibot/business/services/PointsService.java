package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.utils.requests.SubjectRequest;

import java.util.List;

public class PointsService {
    public int calculatePoints(List<SubjectRequest> subjectRequests) {

        int points = subjectRequests
                .stream()
                .map(SubjectRequest::getPoints)
                .reduce(0, Integer::sum);

        System.out.println("Total points : " + points);
        return points;
    }
}
