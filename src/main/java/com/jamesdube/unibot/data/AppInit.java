package com.jamesdube.unibot.data;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppInit implements ApplicationRunner {

    private SampleData sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sampleData.createSampleData();
    }
}