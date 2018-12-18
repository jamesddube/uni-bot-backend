package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.repository.DegreeRepository;
import com.jamesdube.unibot.utils.enums.Classification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;

public class DegreeMatcherService {

    private DegreeRepository degreeRepository;

    public DegreeMatcherService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    public List<Degree> getDegrees(Classification classification, int points) {
        return degreeRepository.findDegreeByClassificationAndMinimumPointsLessThanEqual(classification,points);
    }
}
