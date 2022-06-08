package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.service.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("recuitment")
public class RecruitmentNewController {

    @Autowired
    RecruitmentNewService recruitmentNewService;

    @GetMapping("/list")
    public ResponseEntity<?> showListRecuitmentNew() {
        List<RecuitmentNew> recuitmentNewList = (List<RecuitmentNew>) recruitmentNewService.findAll();
        if (recuitmentNewList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
