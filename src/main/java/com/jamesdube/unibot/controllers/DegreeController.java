package com.jamesdube.unibot.controllers;

import com.jamesdube.unibot.domain.Degree;
import com.jamesdube.unibot.services.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DegreeController {

    @Autowired
    private DegreeService degreeService;

    @GetMapping("/degrees")
    public List<Degree> index(){
        return degreeService.all();
    }

    @PostMapping("/degrees")
    public Degree create(@RequestBody Degree degree){
        return degreeService.add(degree);
    }

    @GetMapping("/degrees/{id}")
    public Degree find(@PathVariable String id){
        return degreeService.find(id);
    }

    @PatchMapping("/degrees/{id}")
    public Degree edit(@PathVariable String id,@RequestBody Degree degreeRequest) {
        return degreeService.edit(id,degreeRequest);
    }

    @DeleteMapping("degrees/{id}")
    public void delete(@PathVariable String id){
        degreeService.delete(id);
    }
}
