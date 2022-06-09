package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.company.CompanyForm;
import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.model.entity.City;
import com.codegym.finalproject.model.entity.Company;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.security.userprincipal.UserDetailServices;
import com.codegym.finalproject.service.account.IAccountService;
import com.codegym.finalproject.service.city.ICityService;
import com.codegym.finalproject.service.company.ICompanyService;
import com.codegym.finalproject.service.recuitmentNew.IRecuitmentNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @Autowired
    UserDetailServices userDetailServices;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRecuitmentNewService recuitmentNewService;

    @Autowired
    Environment env;

    @ModelAttribute("city")
    public Iterable<City> cities(){
        return cityService.findAll();
    }

    @ModelAttribute("account")
    public Iterable<Account> accounts() {
        return accountService.findAll();
    }

    @ModelAttribute("recuitmentNew")
    public Iterable<RecuitmentNew> recuitmentNews(){
        return recuitmentNewService.findAll();
    }

    @GetMapping
    public ResponseEntity<Iterable<Company>> findAll() {
        Iterable<Company> companies = companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        Optional<Company> companyOptional = companyService.findById(id);
        if (!companyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companyOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @ModelAttribute CompanyForm companyForm) {
        Optional<Company> companyOptional = companyService.findById(id);
        companyForm.setId(companyOptional.get().getId());
        MultipartFile multipartFile = companyForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path");
        Company existCompany = new Company(id,companyForm.getCodeCompany() ,companyForm.getName(), fileName, companyForm.getDescription(),companyForm.getAddress(),companyForm.getEmplployeeQuantity(),companyForm.getCity(),companyForm.getLinkMap(),companyForm.getPhone(),companyForm.getStatusCompany(),companyForm.getAccount(),companyForm.getRecuitmentNews());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (existCompany.getAvatar().equals("filename.jpg")){
            existCompany.setAvatar(companyOptional.get().getAvatar());
        }
        companyService.save(existCompany);
        return new ResponseEntity<>(existCompany, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@ModelAttribute CompanyForm companyForm) {
        MultipartFile multipartFile = companyForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path");
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Company company = new Company(companyForm.getCodeCompany() ,companyForm.getName(), fileName, companyForm.getDescription(),companyForm.getAddress(),companyForm.getEmplployeeQuantity(),companyForm.getCity(),companyForm.getLinkMap(),companyForm.getPhone(),companyForm.getStatusCompany(),companyForm.getAccount(),companyForm.getRecuitmentNews());

        companyService.save(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        Optional<Company> companyOptional = companyService.findById(id);
        if (!companyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyService.deleteById(id);
        return new ResponseEntity<>(companyOptional.get(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> detailCompany(@PathVariable Long id) {
//        Optional<Company> company = companyService.findById(id);
//        if (!company.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(company, HttpStatus.OK);
//    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<?> findByStatus(@PathVariable Integer status) {
        List<Company> companyList = companyService.findCompanyByStatus(status);
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Company>> findByName(@PathVariable String name) {
        List<Company> list = companyService.findByName('%' + name + '%');
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

//    @PutMapping("/change_status")
//    public ResponseEntity<?> updateCompanyStatus(@PathVariable Long id, @RequestBody StatusRequest statusRequest) {
//        Account account = userDetailServices.getCurrentUser();
//        if ()
//    }
}
