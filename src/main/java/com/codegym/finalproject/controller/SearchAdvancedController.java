package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.service.recuitmentNew.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAdvancedController {

    @Autowired
    private RecruitmentNewService recruimentService;

    //  Tìm kiếm job theo thành phố và công ty
    @GetMapping("them duong dan vao day")
    public ResponseEntity<?> searchJobByCompAndCity(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.search(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    //  Tìm kiếm job theo ngành nghề, địa chỉ
    @GetMapping("/field")
    public ResponseEntity<?> searchJobByField(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.searchByField(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    // Tìm kiếm nhanh job theo ngành nghề
    @GetMapping
    public ResponseEntity<?> quickSearchByField(@RequestParam("query") String field) {
        try {
            return new ResponseEntity<>(recruimentService.quickSearchByField(new SearchJob(field)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    // Tìm kiếm NHANH job theo địa chỉ
    @GetMapping("/q-search/city")
    public ResponseEntity<?> quickSearchByCity(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.quickSearchByCity(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not Found", HttpStatus.OK);
        }
    }
}
