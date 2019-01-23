package com.jamesdube.unibot.services;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.domain.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.jamesdube.unibot.utils.Classification.SCIENCES;

@Service
public class DegreeService {

    private List<Degree> degrees = new ArrayList<>(Arrays.asList(
            new Degree("HINFO","INFORMATION SYSTEMS",SCIENCES),
            new Degree("HCS","COMPUTER SCIENCE",SCIENCES)));

    public List<Degree> all(){
        return degrees;
    }

    public Degree add(Degree degree) {

        degrees.add(degree);
        return degree;
    }

    public Degree find(String id) {
        return degrees.stream()
                .filter(s -> s.getCode()
                        .equals(id))
                .findFirst()
                .get();
    }

    public Degree edit(String id, Degree degreeRequest) {
        int index = getIndex(id);
        all().set(index,degreeRequest);

        return find(id);
    }

    public void delete(String id){
        all().remove(getIndex(id));
    }

    private int getIndex(String id) {
        return all().indexOf(find(id));
    }
}
