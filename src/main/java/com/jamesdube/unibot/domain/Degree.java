package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.Classification;

public class Degree {

    private String code;
    private String name;
    private Classification classification;

    public Degree(String code, String name, Classification classification) {
        this.code = code;
        this.name = name;
        this.classification = classification;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }
}
