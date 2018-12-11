package com.jamesdube.unibot.controllers;

import com.google.gson.Gson;
import com.jamesdube.unibot.config.UnibotConfig;
import com.jamesdube.unibot.utils.requests.RecommendationRequest;
import com.jamesdube.unibot.utils.requests.SubjectRequest;
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

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
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
}
