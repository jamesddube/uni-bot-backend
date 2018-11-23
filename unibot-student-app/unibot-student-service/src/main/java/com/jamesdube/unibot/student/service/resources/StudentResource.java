package com.jamesdube.unibot.student.service.resources;

import com.jamesdube.unibot.student.business.services.StudentService;
import com.jamesdube.unibot.student.domain.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentResource {

    private StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Student> index(){
        return studentService.all();
    }
}
