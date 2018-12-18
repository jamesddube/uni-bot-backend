package com.jamesdube.unibot.data;

import com.jamesdube.unibot.domain.Degree;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.enums.Classification.ARTS;
import static com.jamesdube.unibot.utils.enums.Classification.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;

class DegreeBuilder {

    static List<Degree> createDegrees() {
        return Arrays.asList(
                new Degree(1L,"HCOM","COMMUNICATION STUDIES",ARTS,9),
                new Degree(2L,"HIS","HISTORY STUDIES",ARTS,5),
                new Degree(3L,"HACC","ACCOUNTING",COMMERCIALS,8),
                new Degree(4L,"HBUS","BUSINESS STUDIES",COMMERCIALS,10),
                new Degree(5L,"HINFO","INFORMATION SYSTEMS",SCIENCES,10),
                new Degree(6L,"HCS","COMPUTER SCIENCE",SCIENCES,12),
                new Degree(7L,"HFSC","FOOD SCIENCE",SCIENCES,7));
    }
}
