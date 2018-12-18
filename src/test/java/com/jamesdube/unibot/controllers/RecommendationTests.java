package com.jamesdube.unibot.controllers;

import com.google.gson.Gson;
import com.jamesdube.unibot.config.UnibotConfig;
import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.repository.DegreeRepository;
import com.jamesdube.unibot.utils.requests.RecommendationRequest;
import com.jamesdube.unibot.utils.requests.SubjectRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.enums.Classification.ARTS;
import static com.jamesdube.unibot.utils.enums.Classification.COMMERCIALS;
import static com.jamesdube.unibot.utils.enums.Classification.SCIENCES;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UnibotConfig.class })
@WebAppConfiguration
public class RecommendationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DegreeRepository degreeRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        degreeRepository.deleteAll();
    }


    @Test
    public void contextLoads(){

    }

    @Test
    public void itCanGetARecommendation() throws Exception{
        Gson gson = new Gson();

        RecommendationRequest recommendationRequest = new RecommendationRequest();

        recommendationRequest.setSubjectRequests(
                Arrays.asList(new SubjectRequest("APHY",5),new SubjectRequest("AMTM",3)));

        String content = gson.toJson(recommendationRequest);

        this.mockMvc.perform(post("/recommendation")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.points").value(8))
                .andExpect(jsonPath("$.classification").value("SCIENCES"));

    }

    @Test
    public void aRecommendationListsDegreesThatMeetTheMinimumPointsObtained() throws Exception{

        degreeRepository.saveAll(
                Arrays.asList(
                        new Degree(1L,"ACC","ACCOUNTING",COMMERCIALS,5),
                        new Degree(2L,"BUS","BUSINESS STUDIES",COMMERCIALS,5),
                        new Degree(3L,"HENG","ENGLISH STUDIES",ARTS,5),
                        new Degree(4L,"HINFO","INFORMATION SYSTEMS",SCIENCES,5),
                        new Degree(5L,"HCS","COMPUTER SCIENCE",SCIENCES,7),
                        new Degree(6L,"HFSC","FOOD SCIENCE",SCIENCES,3))
                );
        Assert.assertEquals(6, degreeRepository.findAll().size());

        Gson gson = new Gson();
        RecommendationRequest recommendationRequest = new RecommendationRequest();
        recommendationRequest.setSubjectRequests(
                Arrays.asList(new SubjectRequest("APHY",5),new SubjectRequest("AMTM",5)));

        String content = gson.toJson(recommendationRequest);

        this.mockMvc.perform(post("/recommendation")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.degrees").isArray())
                .andExpect(jsonPath("$.degrees",hasSize(3)))
                .andExpect(jsonPath("$.degrees[0].minimumPoints").value(isIn(Arrays.asList(5,7,3))))
                .andExpect(jsonPath("$.degrees[1].minimumPoints").value(isIn(Arrays.asList(5,7,3))))
                .andExpect(jsonPath("$.degrees[2].minimumPoints").value(isIn(Arrays.asList(5,7,3))));

    }
}
