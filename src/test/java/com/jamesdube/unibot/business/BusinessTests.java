package com.jamesdube.unibot.business;

import com.jamesdube.unibot.business.services.ClassificationService;
import com.jamesdube.unibot.business.services.PointsService;
import com.jamesdube.unibot.business.services.RecommendationService;
import com.jamesdube.unibot.business.services.SubjectService;
import com.jamesdube.unibot.utils.enums.SubjectCategory;
import com.jamesdube.unibot.utils.requests.SubjectRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.jamesdube.unibot.utils.enums.SubjectCategory.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.SubjectCategory.SCIENCES;

public class BusinessTests {

    private ClassificationService service;

    @Test
    public void itCanCalculateClassification(){

        service = new ClassificationService(new SubjectService());

        SubjectRequest subjectRequestA = new SubjectRequest();
        subjectRequestA.setCode("AMTM");
        subjectRequestA.setPoints(5);

        SubjectRequest subjectRequestB = new SubjectRequest();
        subjectRequestB.setCode("AGEO");
        subjectRequestB.setPoints(4);

        SubjectRequest subjectRequestC = new SubjectRequest();
        subjectRequestC.setCode("APHY");
        subjectRequestC.setPoints(3);

        SubjectRequest subjectRequestD = new SubjectRequest();
        subjectRequestD.setCode("ABUS");
        subjectRequestD.setPoints(4);

        SubjectRequest subjectRequestE = new SubjectRequest();
        subjectRequestE.setCode("AACC");
        subjectRequestE.setPoints(3);

        SubjectCategory sciencesClassification = service.calculateCategory(Arrays
                .asList(subjectRequestA, subjectRequestB, subjectRequestC));

        SubjectCategory commercialsClassification = service.calculateCategory(Arrays
                .asList(subjectRequestD, subjectRequestE, subjectRequestB));

        Assert.assertEquals(SCIENCES,sciencesClassification);
        Assert.assertEquals(COMMERCIALS,commercialsClassification);
    }

    @Test
    public void itCanCalculatePoints(){

        PointsService pointsService = new PointsService();

        SubjectRequest subjectRequestA = new SubjectRequest();
        subjectRequestA.setCode("AMTM");
        subjectRequestA.setPoints(5);

        SubjectRequest subjectRequestB = new SubjectRequest();
        subjectRequestB.setCode("AGEO");
        subjectRequestB.setPoints(4);

        SubjectRequest subjectRequestC = new SubjectRequest();
        subjectRequestC.setCode("APHY");
        subjectRequestC.setPoints(3);

        SubjectRequest subjectRequestD = new SubjectRequest();
        subjectRequestD.setCode("ABUS");
        subjectRequestD.setPoints(4);

        SubjectRequest subjectRequestE = new SubjectRequest();
        subjectRequestE.setCode("AACC");
        subjectRequestE.setPoints(3);

        int pointsA = pointsService.calculatePoints(Arrays
                .asList(subjectRequestA, subjectRequestB, subjectRequestC));

        int pointsB = pointsService.calculatePoints(Arrays
                .asList(subjectRequestE, subjectRequestD, subjectRequestC));

        Assert.assertEquals(12,pointsA);
        Assert.assertEquals(10,pointsB);
    }
}
