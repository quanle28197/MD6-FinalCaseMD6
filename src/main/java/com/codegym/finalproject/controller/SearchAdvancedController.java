package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.service.recuitmentNew.RecruitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchAdvancedController {

    @Autowired
    private RecruitmentNewService recruimentService;

    //  Tìm kiếm job theo thành phố và công ty
    @GetMapping("/result")
    public ResponseEntity<?> searchJobByCompAndCity(@RequestParam("query") String data) {
        try {
            return new ResponseEntity<>(recruimentService.search(new SearchJob(data)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    //  Tìm kiếm job theo ngành nghề, địa chỉ
    @PostMapping("/field")
    public ResponseEntity<?> searchJobByField(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.searchByField(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    // Tìm kiếm nhanh job theo ngành nghề
    @PostMapping("/q-search/field")
    public ResponseEntity<?> quickSearchByField(@RequestBody SearchJob searchJob) {
        try {
            return new ResponseEntity<>(recruimentService.quickSearchByField(searchJob), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not found", HttpStatus.OK);
        }
    }

    // Tìm kiếm NHANH job theo địa chỉ
    @GetMapping("/q-search/city")
    public ResponseEntity<?> quickSearchByCity(@RequestParam("query") String name){
        try {
            return new ResponseEntity<>(recruimentService.quickSearchByCity(new SearchJob(name)), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Not Found", HttpStatus.OK);
        }
    }
}
