package com.jamesdube.unibot.business.services;

import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.repository.SubjectRepository;
import com.jamesdube.unibot.utils.enums.Classification;

import java.util.Objects;

public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject getSubjectByCode(String code) {

        return subjectRepository.findByCode(code);
    }
}
