package com.jamesdube.unibot.utils.response;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.utils.enums.Classification;
import lombok.Data;

import java.util.List;

@Data
public class RecommendationResponse {

    private int points;

    private Classification classification;

    private List<Degree> degrees;

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Classification getClassification() {
        return classification;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return "RecommendationResponse{" +
                "points=" + points +
                ", classification=" + classification +
                '}';
    }
}
