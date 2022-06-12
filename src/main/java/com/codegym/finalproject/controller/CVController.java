package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.CvDTO;
import com.codegym.finalproject.model.entity.CV;
import com.codegym.finalproject.service.CV.CVService;
import com.codegym.finalproject.service.skill.SkillService;
import com.codegym.finalproject.service.user.UserService;
import com.codegym.finalproject.service.workExp.WorkExpService;
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

    @Autowired
    SkillService skillService;

    @Autowired
    WorkExpService workExpService;

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
//
//    @PostMapping("/createCV")
//    public ResponseEntity<?> create(@RequestBody CvDTO cvDTO) {
//        CV cv1 = new CV();
//        cv1 = cv1.toEntity(cvDTO);
//        if (cvService.existByUserId(cvDTO.getUserId())) {
//        }
//    }
}
