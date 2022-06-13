package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.service.recuitmentNew.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchAdvancedController {

    @Autowired
    private RecruitmentNewService recruimentService;

    //  Tìm kiếm job theo thành phố và công ty
    @PostMapping
    public ResponseEntity<?> searchJobByCompAndCity(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.search(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }
    //  Tìm kiếm job theo

}
