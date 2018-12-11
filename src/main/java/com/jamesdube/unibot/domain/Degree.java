package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.enums.DegreeCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Degree {

    @Id
    Long id;

    @Column
    String code;

    @Column
    String name;

    @Column
    DegreeCategory category;

    @Column
    int minimumPoints;
}
