package com.jamesdube.unibot.domain;

import com.jamesdube.unibot.utils.enums.Classification;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Data
public class Degree {

    @Id
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private Classification classification;

    @Column
    private int minimumPoints;

    public Degree() {
    }

    public Degree(Long id, String code, String name, Classification classification, int minimumPoints) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.classification = classification;
        this.minimumPoints = minimumPoints;
    }
}

