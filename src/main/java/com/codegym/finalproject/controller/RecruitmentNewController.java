package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.service.recuitmentNew.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("recruitment")
public class RecruitmentNewController {
    @Autowired
    RecruitmentNewService recruitmentNewService;

    @GetMapping("/list")
    public ResponseEntity<?> showListRecruitmentNew() {
        List<RecuitmentNew> recuitmentNewList = (List<RecuitmentNew>) recruitmentNewService.findAll();
        if (recuitmentNewList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(recuitmentNewList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRecruitmentNew(@RequestBody RecuitmentNew recuitmentNew) {
        if (recuitmentNew.getQuantity() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_quantity"), HttpStatus.OK);
        }
        //tao codeCompany
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
        Optional<RecuitmentNew> recuitmentNew = recruitmentNewService.findById(id);
        if (!recuitmentNew.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recuitmentNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecruitmentNew(@PathVariable Long id) {
        Optional<RecuitmentNew> recuitmentNew = recruitmentNewService.findById(id);
        if (!recuitmentNew.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recruitmentNewService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecruitmentNew(@PathVariable Long id, @RequestBody RecuitmentNew recuitmentNew) {
        Optional<RecuitmentNew> recuitmentNew1 = recruitmentNewService.findById(id);
        if (!recuitmentNew1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (recuitmentNew.getQuantity() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_quantity"), HttpStatus.OK);
        }
        if (recuitmentNew.getSalary() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_salary"), HttpStatus.OK);
        }
        recuitmentNew1.get().setTitle(recuitmentNew.getTitle());
        recuitmentNew1.get().setWorkingTime(recuitmentNew.getWorkingTime());
        recuitmentNew1.get().setField(recuitmentNew.getField());
        recuitmentNew1.get().setVacancies(recuitmentNew.getVacancies());
        recuitmentNew1.get().setExpDate(recuitmentNew.getExpDate());
        recuitmentNew1.get().setDescription(recuitmentNew.getDescription());
        recuitmentNew1.get().setQuantity(recuitmentNew.getQuantity());
        recuitmentNew1.get().setSalary(recuitmentNew.getSalary());
        recuitmentNew1.get().setGender(recuitmentNew.getGender());
        recuitmentNew1.get().setCity(recuitmentNew.getCity());
        recruitmentNewService.save(recuitmentNew1.get());
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);

    }

    @GetMapping("/showAll/{id}")
    public ResponseEntity<?> findAllByCompany(@PathVariable Long id) {
        return new ResponseEntity<>(recruitmentNewService.findAllByCompany_Id(id), HttpStatus.OK);
    }

    @GetMapping("/quick-search")
    public ResponseEntity<?> quickSearchByField(@RequestParam("query") String field) {
        try {
            return new ResponseEntity<>(recruitmentNewService.quickSearchByField(new SearchJob(field)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    // Tìm kiếm NHANH job theo địa chỉ
    @GetMapping("/q-search/city")
    public ResponseEntity<?> quickSearchByCity(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruitmentNewService.quickSearchByCity(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not Found", HttpStatus.OK);
        }
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
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
}
