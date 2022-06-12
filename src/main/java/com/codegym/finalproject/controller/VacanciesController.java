package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.entity.Field;
import com.codegym.finalproject.model.entity.Vacancies;
import com.codegym.finalproject.service.vacancies.IVacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("vacancies")
public class VacanciesController {

    @Autowired
    private IVacanciesService vacanciesService;

    @GetMapping()
    public ResponseEntity<Iterable<Vacancies>> findAll() {
        return new ResponseEntity<>(vacanciesService.findAll(), HttpStatus.OK);
    }
}
