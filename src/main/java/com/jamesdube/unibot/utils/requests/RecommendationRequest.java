package com.jamesdube.unibot.utils.requests;

import com.jamesdube.unibot.domain.Subject;
import lombok.Data;

import java.util.List;

public class RecommendationRequest {

    private List<SubjectRequest> subjectRequests;

    @Override
    public String toString() {
        return "RecommendationRequest{" +
                "subjectRequests=" + subjectRequests +
                '}';
    }

    public void setSubjectRequests(List<SubjectRequest> subjectRequests) {
        this.subjectRequests = subjectRequests;
    }

    public List<SubjectRequest> getSubjectRequests() {
        return subjectRequests;
    }
}
