//package com.codegym.finalproject.controller;
//
//import com.codegym.finalproject.model.entity.Account;
//import com.codegym.finalproject.model.entity.City;
//import com.codegym.finalproject.model.entity.Company;
//import com.codegym.finalproject.model.entity.RecuitmentNew;
//import com.codegym.finalproject.service.account.IAccountService;
//import com.codegym.finalproject.service.city.ICityService;
//import com.codegym.finalproject.service.company.ICompanyService;
//import com.codegym.finalproject.service.recuitmentNew.IRecuitmentNewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/recuitmentnew")
//public class RecuitmentNewController {
//    @Autowired
//    private ICompanyService companyService;
//
//    @Autowired
//    private ICityService cityService;
//
//    @Autowired
//    private IAccountService accountService;
//
//    @Autowired
//    private IRecuitmentNewService recuitmentNewService;
//
//    @Autowired
//    Environment env;
//
//    @ModelAttribute("city")
//    public Iterable<City> cities(){
//        return cityService.findAll();
//    }
//
//    @ModelAttribute("account")
//    public Iterable<Account> accounts() {
//        return accountService.findAll();
//    }
//
//    @ModelAttribute("company")
//    public Iterable<Company> companies() {
//        return companyService.findAll();
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<RecuitmentNew>> findAll() {
//        Iterable<RecuitmentNew> recuitmentNews = recuitmentNewService.findAll();
//        return new ResponseEntity<>(recuitmentNews, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RecuitmentNew> findById(@PathVariable Long id) {
//        Optional<RecuitmentNew> recuitmentNewOptional = recuitmentNewService.findById(id);
//        if (!recuitmentNewOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(recuitmentNewOptional.get(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<RecuitmentNew> createRecuitmentNew(@RequestBody RecuitmentNew recuitmentNew) {
//        return new ResponseEntity<>(recuitmentNewService.save(recuitmentNew), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<RecuitmentNew> updateRecuitmentNew(@PathVariable Long id, @RequestBody RecuitmentNew recuitmentNew) {
//        Optional<RecuitmentNew> recuitmentNewOptional = recuitmentNewService.findById(id);
//        if (!recuitmentNewOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        recuitmentNew.setId(id);
//        return new ResponseEntity<>(recuitmentNewService.save(recuitmentNew), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<RecuitmentNew> deleteRecuitmentNew(@PathVariable Long id) {
//        Optional<RecuitmentNew> recuitmentNewOptional = recuitmentNewService.findById(id);
//        if (!recuitmentNewOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        recuitmentNewService.removeById(id);
//        return new ResponseEntity<>(recuitmentNewOptional.get(), HttpStatus.OK);
//    }
//}
