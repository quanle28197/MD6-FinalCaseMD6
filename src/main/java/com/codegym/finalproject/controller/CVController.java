package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.entity.CV;
import com.codegym.finalproject.service.CVService;
import com.codegym.finalproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("CV")
@RestController
public class CVController {

    @Autowired
    CVService cvService;

    @Autowired
    UserService userService;

    @GetMapping("/showAll")
    public ResponseEntity<?> showAll() {
        return new ResponseEntity<>(cvService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailCV(@PathVariable Long id) {
        Optional<CV> cv = cvService.findById(id);
        if (!cv.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }
}
