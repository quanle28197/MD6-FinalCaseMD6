package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.service.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping()
    public ResponseEntity<?> createRecruitmentNew(@RequestBody RecuitmentNew recuitmentNew) {
        if  (recuitmentNew.getQuantity() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_quantity"), HttpStatus.OK);
        }

//        code Company
        String nameex = recuitmentNew.getTitle().substring(0, 3);
        int min = 100;
        int max = 999;
        String nameCompany = String.valueOf((int) Math.floor(Math.round((Math.random() * (max - min + 1) + min))));
        ;
        recuitmentNew.setCodeNews(nameex + nameCompany);
        System.out.println(recuitmentNew.getCodeNews());
        recuitmentNew.setStatus(true);

        recruitmentNewService.save(recuitmentNew);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailRecruitmentNew(@PathVariable Long id) {
        Optional<RecuitmentNew > recuitmentNew = recruitmentNewService.findById(id);
        if (!recuitmentNew.isPresent()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recuitmentNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecuitmentNew(@PathVariable Long id) {
        Optional<RecuitmentNew> recuitmentNew = recruitmentNewService.findById(id);
        if (!recuitmentNew.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recruitmentNewService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("oki"), HttpStatus.OK);
    }

    @GetMapping("/showAll/{id}")
    public ResponseEntity<?> findAllByCompany(@PathVariable Long id) {
        return new ResponseEntity<>(recruitmentNewService.findAllbyCompany_Id(id), HttpStatus.OK);
    }

    @PutMapping("/editStatus/{id}")
    public ResponseEntity<?> editStatus(@PathVariable Long id) {
        Optional<RecuitmentNew> recuitmentNewOptional = recruitmentNewService.findById(id);
        if (recuitmentNewOptional.get().getStatus()) {
            recuitmentNewOptional.get().setStatus(false);
        } else {
            recuitmentNewOptional.get().setStatus(true);
        }
        recruitmentNewService.save(recuitmentNewOptional.get());
        return new ResponseEntity<>(new ResponseMessage("got it"), HttpStatus.OK);
    }

}
