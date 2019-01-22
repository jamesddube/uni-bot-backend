package com.jamesdube.unibot.business;

import com.jamesdube.unibot.business.services.ClassificationService;
import com.jamesdube.unibot.business.services.PointsService;
import com.jamesdube.unibot.business.services.SubjectService;
import com.jamesdube.unibot.config.UnibotConfig;
import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.repository.SubjectRepository;
import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.requests.SubjectRequest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

import static com.jamesdube.unibot.utils.enums.Classification.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UnibotConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class RecommendationTest {

    private ClassificationService service;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void itCanCalculateClassification(){


        service = new ClassificationService(new SubjectService(subjectRepository));

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

        subjectRepository.saveAll(
                Arrays.asList(
                        new Subject("AMTM",SCIENCES),
                        new Subject("AGEO",SCIENCES),
                        new Subject("APHY",SCIENCES),
                        new Subject("ABUS",COMMERCIALS),
                        new Subject("AACC",COMMERCIALS)
                )
        );

        Classification sciencesClassification = service.calculateCategory(Arrays
                .asList(subjectRequestA, subjectRequestB, subjectRequestC));

        Classification commercialsClassification = service.calculateCategory(Arrays
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
