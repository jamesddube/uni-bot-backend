package com.jamesdube.unibot.utils.response;

import com.jamesdube.unibot.utils.enums.Classification;
import lombok.Data;

@Data
public class RecommendationResponse {

    private int points;

    private Classification classification;

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "RecommendationResponse{" +
                "points=" + points +
                ", classification=" + classification +
                '}';
    }
}
