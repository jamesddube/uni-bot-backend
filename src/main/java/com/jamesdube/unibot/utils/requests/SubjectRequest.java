package com.jamesdube.unibot.utils.requests;

import lombok.Data;

@Data
public class SubjectRequest {

    private String code;

    private int points;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "SubjectRequest{" +
                "code='" + code + '\'' +
                ", points=" + points +
                '}';
    }
}
