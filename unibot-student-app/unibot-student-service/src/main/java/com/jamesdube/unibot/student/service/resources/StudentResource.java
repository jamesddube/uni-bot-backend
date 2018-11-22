package com.jamesdube.unibot.student.service.resources;

import com.jamesdube.unibot.student.domain.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentResource {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student create(@RequestBody Student student){
        return student;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Student> index(){
        return Arrays.asList(
                new Student("Daenerys","Targaryen"),
                new Student("John","Snow"));
    }
}
