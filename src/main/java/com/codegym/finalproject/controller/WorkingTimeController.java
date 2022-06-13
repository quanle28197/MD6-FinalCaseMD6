package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.entity.WorkingTime;
import com.codegym.finalproject.service.workingTime.IWorkingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/workingTime")

public class WorkingTimeController {
    @Autowired
    private IWorkingTimeService workingTimeService;

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<WorkingTime>> showAll(){
        return new ResponseEntity<>(workingTimeService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<WorkingTime> createWorkingTime(@RequestBody WorkingTime workingTime){
        return new ResponseEntity<>(workingTimeService.save(workingTime),HttpStatus.CREATED);
    }
}
