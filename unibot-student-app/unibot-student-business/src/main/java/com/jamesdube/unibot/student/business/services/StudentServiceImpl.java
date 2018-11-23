package com.jamesdube.unibot.student.business.services;

import com.jamesdube.unibot.student.domain.models.Student;
import com.jamesdube.unibot.student.repository.api.StudentRepository;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }
}
