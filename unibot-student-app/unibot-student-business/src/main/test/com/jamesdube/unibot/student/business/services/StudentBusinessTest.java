package com.jamesdube.unibot.student.business.services;

import com.jamesdube.unibot.student.domain.models.Student;
import com.jamesdube.unibot.student.repository.api.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class StudentBusinessTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentService studentService;

    @Test
    public void can_create_a_student() throws Exception {

        Student student = new Student(555L, "Jim", "Jones");
        when(studentRepository.save(student)).thenReturn(student);
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));

        studentService = new StudentServiceImpl(studentRepository);

        Student savedStudent = studentService.create(student);

        assertNotNull(student);
        assertEquals("Jim",savedStudent.getFirstName());
        assertEquals(1,studentService.all().size());

    }
}
