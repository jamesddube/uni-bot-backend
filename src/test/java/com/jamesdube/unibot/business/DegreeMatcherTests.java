package com.jamesdube.unibot.business;

import com.jamesdube.unibot.business.services.DegreeMatcherService;
import com.jamesdube.unibot.config.UnibotConfig;
import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.repository.DegreeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.enums.Classification.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnibotConfig.class })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class DegreeMatcherTests{

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private DegreeMatcherService degreeMatcherService;

    @Before
    public void before(){

    }

    @Test
    public void itGetsDegreesBasedOnMinimumPoints(){

        degreeRepository.saveAll(
                Arrays.asList(
                        new Degree(1L,"HINFO","COMMUNICATION STUDIES",ARTS,9),
                        new Degree(2L,"HINFO","HISTORY STUDIES",ARTS,5),
                        new Degree(3L,"HINFO","ACCOUNTING",COMMERCIALS,8),
                        new Degree(4L,"HINFO","BUSINESS STUDIES",COMMERCIALS,10),
                        new Degree(5L,"HINFO","INFORMATION SYSTEMS",SCIENCES,10),
                        new Degree(6L,"HCS","COMPUTER SCIENCE",SCIENCES,12),
                        new Degree(7L,"HCS","COMPUTER SCIENCE",SCIENCES,10),
                        new Degree(8L,"HFSC","FOOD SCIENCE",SCIENCES,7))
        );

        assertEquals(8, degreeRepository.findAll().size());

        List<Degree> degreeList = degreeMatcherService.getDegrees(ARTS,9);
        assertEquals(2,degreeList.size());

        degreeList = degreeMatcherService.getDegrees(ARTS,5);
        assertEquals(1,degreeList.size());
        assertEquals("HISTORY STUDIES",degreeList.get(0).getName());

        degreeList = degreeMatcherService.getDegrees(COMMERCIALS,5);
        assertEquals(0,degreeList.size());

        degreeList = degreeMatcherService.getDegrees(COMMERCIALS,13);
        assertEquals(2,degreeList.size());

        degreeList = degreeMatcherService.getDegrees(SCIENCES,15);
        assertEquals(4,degreeList.size());



    }


}
