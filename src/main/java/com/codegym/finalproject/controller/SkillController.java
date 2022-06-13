package com.codegym.finalproject.controller;


import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.Skill;
import com.codegym.finalproject.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("Skill")
@RestController
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/showAll")
    public ResponseEntity<?> showAll() {
        return new ResponseEntity<>(skillService.findAll(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> createSkill(@RequestBody Skill skill){
        if(skill.getName()==null){
            return new ResponseEntity<>(new ResponseMessage("no_name_skill"), HttpStatus.OK);
        }
        skillService.save(skill);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody Skill skill){
        Optional<Skill> skill1 = skillService.findById(id);
        if(!skill1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(skill.getName()==null){
            return new ResponseEntity<>(new ResponseMessage("no_name_skill"), HttpStatus.OK);
        }
        skill1.get().setName(skill.getName());
        skill1.get().setCv(skill.getCv());
        skillService.save(skill1.get());
        return new ResponseEntity<>(skill1.get(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> detailSkill(@PathVariable Long id) {
        Optional<Skill> skill = skillService.findById(id);
        if (!skill.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCV(@PathVariable Long id) {
        Optional<Skill> skill = skillService.findById(id);
        if (!skill.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        skillService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/cv/{id}")
    public ResponseEntity<?> findSkillByCvId(@PathVariable Long id) {
        List<Skill> skill = (List<Skill>) skillService.findAllSkillsByCvId(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
}

