package com.jamesdube.unibot.domain.models;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class Degree {

    private String name;

    private String code;

    public Degree() {
    }

    public Degree(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
