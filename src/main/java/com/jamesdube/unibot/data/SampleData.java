package com.jamesdube.unibot.data;

import com.jamesdube.unibot.repository.DegreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SampleData {

    private DegreeRepository degreeRepository;

    void createSampleData() {
        degreeRepository.saveAll(DegreeBuilder.createDegrees());
    }
}
