package com.jamesdube.unibot.student.business.services;

import com.jamesdube.unibot.student.domain.models.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    List<Student> all();
}
