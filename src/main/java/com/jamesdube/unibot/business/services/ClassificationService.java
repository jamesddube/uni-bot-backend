package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.utils.enums.Classification;
import com.jamesdube.unibot.utils.requests.SubjectRequest;

import java.util.List;

import static com.jamesdube.unibot.utils.enums.Classification.ARTS;
import static com.jamesdube.unibot.utils.enums.Classification.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;

public class ClassificationService {

    private SubjectService subjectService;

    public ClassificationService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public Classification calculateCategory(List<SubjectRequest> subjectRequests){

        int commercial = 0;
        int sciences =0;
        int arts = 0;

        for (SubjectRequest subjectRequest : subjectRequests) {

            String code = subjectRequest.getCode();

            Subject subject = subjectService.getDegreeByCode(code);

            switch (subject
                    .getClassification()) {
                case ARTS:
                    arts ++;
                    System.out.println("adding point for ARTS subject : " + subject.getName());
                    break;
                case COMMERCIALS:
                    commercial ++;
                    System.out.println("adding point for COMMERCIALS subject : " + subject.getName());
                    break;
                case SCIENCES:
                    sciences ++;
                    System.out.println("adding point for SCIENCES subject : " + subject.getName());
                    break;
            }
        }

        System.out.println("ARTS: "+arts);
        System.out.println("COMMERCIAL: "+commercial);
        System.out.println("SCIENCE: "+sciences);

        if (arts > commercial && arts > sciences){
            System.out.println("CLASSIFICATION : "+ ARTS);
            return ARTS;
        }
        else if (commercial > arts && commercial > sciences){
            System.out.println("CLASSIFICATION : "+ COMMERCIALS);
            return COMMERCIALS;
        }
        else if(sciences > arts && sciences > commercial){
            System.out.println("CLASSIFICATION : "+ SCIENCES);
            return SCIENCES;
        }

        return null;
    }
}
