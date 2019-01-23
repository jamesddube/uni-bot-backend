package com.jamesdube.unibot.services;

import com.jamesdube.unibot.domain.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.Classification.SCIENCES;

@Service
public class SubjectService {

    private List<Subject> subjects = new ArrayList<>(Arrays.asList(
            new Subject("A-PHY","PHYSICS",SCIENCES),
            new Subject("A-MTM","MATHEMATICS",SCIENCES)));

    public List<Subject> all(){
        return subjects;
    }

    public Subject add(Subject subject) {

        subjects.add(subject);
        return subject;
    }

    public Subject find(String id) {
        return subjects.stream()
                .filter(s -> s.getCode()
                        .equals(id))
                .findFirst()
                .get();
    }
}
