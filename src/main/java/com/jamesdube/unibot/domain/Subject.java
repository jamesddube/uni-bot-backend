package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.enums.SubjectCategory;
import com.jamesdube.unibot.utils.enums.SubjectType;
import lombok.Data;

@Data
public class Subject {

    private String name;

    private SubjectType subjectType;

    private SubjectCategory subjectCategory;


    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", subjectType=" + subjectType +
                ", subjectCategory=" + subjectCategory +
                '}';
    }
}
