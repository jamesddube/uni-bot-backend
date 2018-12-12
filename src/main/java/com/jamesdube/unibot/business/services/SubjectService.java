package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.utils.enums.Classification;

import java.util.Objects;

public class SubjectService {

    public Subject getSubjectByCode(String code) {

        Subject maths = new Subject();
        maths.setName("Mathematics");
        maths.setClassification(Classification.SCIENCES);

        Subject physics = new Subject();
        physics.setName("Physics");
        physics.setClassification(Classification.SCIENCES);

        Subject geo = new Subject();
        geo.setName("Geography");
        geo.setClassification(Classification.COMMERCIALS);

        Subject businessStudies = new Subject();
        businessStudies.setName("Business Studies");
        businessStudies.setClassification(Classification.COMMERCIALS);

        Subject accounting = new Subject();
        accounting.setName("Accounting");
        accounting.setClassification(Classification.COMMERCIALS);

        if (Objects.equals(code, "AMTM")) return maths;
        if (Objects.equals(code, "APHY")) return physics;
        if (Objects.equals(code, "AGEO")) return geo;
        if (Objects.equals(code, "ABUS")) return businessStudies;
        if (Objects.equals(code, "AACC")) return accounting;

        return null;
    }
}
