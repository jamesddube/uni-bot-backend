package com.jamesdube.unibot.business;

import com.jamesdube.unibot.business.services.SubjectService;
import com.jamesdube.unibot.config.UnibotConfig;
import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.repository.SubjectRepository;
import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.enums.SubjectType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;
import static com.jamesdube.unibot.utils.enums.SubjectType.ALEVEL;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UnibotConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class SubjectServiceTests {

    private SubjectService subjectService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void itCanGetASubjectUsingTheSubjectCode(){

        subjectService = new SubjectService(subjectRepository);

        Subject physics = new Subject("APHY","PHYSICS", ALEVEL, SCIENCES);
        Subject maths = new Subject("AMTM","MATHEMATICS", ALEVEL, SCIENCES);

        subjectRepository.saveAll(Arrays.asList(physics, maths));
        assertEquals(2,subjectRepository.findAll().size());

        Subject foundSubject = subjectService.getSubjectByCode("APHY");

        assertEquals(physics.getName(),foundSubject.getName());
        assertEquals("APHY",foundSubject.getCode());
        assertEquals(physics.getClassification(),foundSubject.getClassification());

        foundSubject = subjectService.getSubjectByCode("AMTM");
        assertEquals(maths.getName(),foundSubject.getName());
        assertEquals("AMTM",foundSubject.getCode());
        assertEquals(maths.getClassification(),foundSubject.getClassification());
    }
}
