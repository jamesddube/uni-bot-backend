package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.enums.SubjectType;
import lombok.Data;

@Data
public class Subject {

    private String name;

    private SubjectType subjectType;

    private Classification classification;


    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", subjectType=" + subjectType +
                ", classification=" + classification +
                '}';
    }
}
