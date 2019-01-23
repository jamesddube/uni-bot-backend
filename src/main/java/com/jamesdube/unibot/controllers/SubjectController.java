package com.jamesdube.unibot.controllers;

import com.jamesdube.unibot.domain.Subject;
import com.jamesdube.unibot.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.unibot.utils.Classification.SCIENCES;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> index(){
        return subjectService.all();
    }

    @PostMapping("/subjects")
    public Subject create(@RequestBody Subject subject){
        return subjectService.add(subject);
    }

    @GetMapping("/subjects/{id}")
    public Subject find(@PathVariable String id){
        return subjectService.find(id);
    }

    @PatchMapping("/subjects/{id}")
    public Subject edit(@PathVariable String id,@RequestBody Subject subjectRequest) {

        int index = getIndex(id);
        subjectService.all().set(index,subjectRequest);

        return subjectService.find(id);

    }

    private int getIndex(@PathVariable String id) {
        Subject subject = subjectService.find(id);
        return subjectService.all().indexOf(subject);
    }

    @DeleteMapping("subjects/{id}")
    public void delete(@PathVariable String id){
        subjectService.all().remove(getIndex(id));
    }
}
