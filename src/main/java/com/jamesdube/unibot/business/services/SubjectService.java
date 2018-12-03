package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.utils.enums.SubjectCategory;

import java.util.Objects;

public class SubjectService {

    public Subject getDegreeByCode(String code) {

        Subject maths = new Subject();
        maths.setName("Mathematics");
        maths.setSubjectCategory(SubjectCategory.SCIENCES);

        Subject physics = new Subject();
        physics.setName("Physics");
        physics.setSubjectCategory(SubjectCategory.SCIENCES);

        Subject geo = new Subject();
        geo.setName("Geography");
        geo.setSubjectCategory(SubjectCategory.COMMERCIALS);

        Subject businessStudies = new Subject();
        businessStudies.setName("Business Studies");
        businessStudies.setSubjectCategory(SubjectCategory.COMMERCIALS);

        Subject accounting = new Subject();
        accounting.setName("Accounting");
        accounting.setSubjectCategory(SubjectCategory.COMMERCIALS);

        if (Objects.equals(code, "AMTM")) return maths;
        if (Objects.equals(code, "APHY")) return physics;
        if (Objects.equals(code, "AGEO")) return geo;
        if (Objects.equals(code, "ABUS")) return businessStudies;
        if (Objects.equals(code, "AACC")) return accounting;

        return null;
    }
}
