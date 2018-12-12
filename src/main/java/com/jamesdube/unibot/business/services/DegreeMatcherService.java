package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.utils.enums.Classification;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;

public class DegreeMatcherService {

    public List<Degree> getDegrees(Classification category, int points) {
        return Arrays.asList(
                new Degree(1L,"HINFO","INFORMATION SYSTEMS",SCIENCES,5),
                new Degree(2L,"HCS","COMPUTER SCIENCE",SCIENCES,7));
    }
}
