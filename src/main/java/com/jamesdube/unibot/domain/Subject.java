package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.enums.SubjectType;
import lombok.Data;

import javax.persistence.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private SubjectType subjectType;

    @Column
    private Classification classification;

    public Subject() {
    }

    public Subject(String code,String name, SubjectType subjectType, Classification classification) {
        this.code = code;
        this.name = name;
        this.subjectType = subjectType;
        this.classification = classification;
    }

    public Subject(String code, Classification classification) {
        this.code = code;
        this.classification = classification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", subjectType=" + subjectType +
                ", classification=" + classification +
                '}';
    }
}
