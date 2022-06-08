package com.codegym.finalproject.controller;


import com.codegym.finalproject.service.city.ICityService;
import com.codegym.finalproject.model.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping()
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<City> create(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> edit(@PathVariable Long id,@RequestBody City city) {
        city.setId(id);
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return new ResponseEntity<>(cityService.findById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            cityService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
