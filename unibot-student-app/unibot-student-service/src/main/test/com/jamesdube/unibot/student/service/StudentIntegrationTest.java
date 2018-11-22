package com.jamesdube.unibot.student.service;

import com.jamesdube.unibot.student.domain.models.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {

    private static final int UNKNOWN_ID = Integer.MAX_VALUE;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void can_create_a_student() throws Exception{

        Student student = new Student("Michael","Jacobs");
        HttpEntity<Student> request = new HttpEntity<Student>(student);

        ResponseEntity<Student> response = restTemplate.postForEntity("/api/students",request,Student.class);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Michael",response.getBody().getFirstName());
        assertEquals("Jacobs",response.getBody().getLastName());
    }

    @Test
    public void can_show_a_list_of_students() throws Exception{

        ResponseEntity<Student[]> response;
        response = restTemplate.getForEntity("/api/students",Student[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2,response.getBody().length);


    }
}
