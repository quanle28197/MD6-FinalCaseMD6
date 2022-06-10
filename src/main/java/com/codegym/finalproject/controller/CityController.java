package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.entity.City;
import com.codegym.finalproject.model.entity.Company;
import com.codegym.finalproject.service.account.IAccountService;
import com.codegym.finalproject.service.city.ICityService;
import com.codegym.finalproject.service.company.ICompanyService;
import com.codegym.finalproject.service.recuitmentNew.IRecuitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRecuitmentNewService recuitmentNewService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll() {
        Iterable<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
