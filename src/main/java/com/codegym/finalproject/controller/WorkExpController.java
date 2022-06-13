package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.WorkExp;
import com.codegym.finalproject.service.workExp.WorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("WorkExp")
@RestController
public class WorkExpController {
    @Autowired
    WorkExpService workExpService;

    @GetMapping("/list")
    public ResponseEntity<?> showListWorkExp() {
        List<WorkExp> workExps = (List<WorkExp>) workExpService.findAll();
        if (workExps.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(workExps, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> createWorkExp(@RequestBody WorkExp workExp) {
        if (workExp.getTitle() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_title"), HttpStatus.OK);
        }
        if(workExp.getStartDate()==null){
            return new ResponseEntity<>(new ResponseMessage("no_start_date"), HttpStatus.OK);
        }
        if(workExp.getEndDate()==null){
            return new ResponseEntity<>(new ResponseMessage("no_end_date"), HttpStatus.OK);
        }
        workExpService.save(workExp);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateWorkExp(@PathVariable Long id,@RequestBody WorkExp workExp){
        Optional<WorkExp> workExp1 = workExpService.findById(id);
        if(!workExp1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (workExp.getTitle() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_title"), HttpStatus.OK);
        }
        if(workExp.getStartDate()==null){
            return new ResponseEntity<>(new ResponseMessage("no_start_date"), HttpStatus.OK);
        }
        if(workExp.getEndDate()==null){
            return new ResponseEntity<>(new ResponseMessage("no_end_date"), HttpStatus.OK);
        }

        workExp1.get().setTitle(workExp.getTitle());
        workExp1.get().setContent(workExp.getContent());
        workExp1.get().setCv(workExp.getCv());
        workExp1.get().setStartDate(workExp.getStartDate());
        workExp1.get().setEndDate(workExp.getEndDate());
        workExpService.save(workExp1.get());
        return new ResponseEntity<>(workExp1.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkExp(@PathVariable Long id) {
        Optional<WorkExp> workExp = workExpService.findById(id);
        if (!workExp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        workExpService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailWorkExp(@PathVariable Long id) {
        Optional<WorkExp> workExp = workExpService.findById(id);
        if (!workExp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(workExp, HttpStatus.OK);
    }

    @GetMapping("/cv/{id}")
    public ResponseEntity<?> findWorkingByCvId(@PathVariable Long id) {
        List<WorkExp> workExps = (List<WorkExp>) workExpService.findAllByCv_Id(id);
        return new ResponseEntity<>(workExps, HttpStatus.OK);
    }
}
