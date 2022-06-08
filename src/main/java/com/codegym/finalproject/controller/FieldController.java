package com.codegym.finalproject.controller;


import com.codegym.finalproject.model.entity.Field;
import com.codegym.finalproject.service.field.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/fields")
@CrossOrigin("*")
public class FieldController {
    @Autowired
    private IFieldService fieldService;

    @GetMapping()
    public ResponseEntity<Iterable<Field>> findAll() {
        return new ResponseEntity<>(fieldService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Field> create(@RequestBody Field field) {
        return new ResponseEntity<>(fieldService.save(field),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> edit(@PathVariable Long id,@RequestBody Field field) {
        field.setId(id);
        return new ResponseEntity<>(fieldService.save(field),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> findById(@PathVariable Long id) {
        return new ResponseEntity<>(fieldService.findById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Field> deleteById(@PathVariable Long id) {
        Optional<Field> field = fieldService.findById(id);
        if (field.isPresent()) {
            fieldService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}