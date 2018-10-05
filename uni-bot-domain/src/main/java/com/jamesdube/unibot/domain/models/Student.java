package com.jamesdube.unibot.domain.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Student {

    private String firstName;

    private String lastName;

    private String idNumber;

    public Student() {
    }

    public Student(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }
}
