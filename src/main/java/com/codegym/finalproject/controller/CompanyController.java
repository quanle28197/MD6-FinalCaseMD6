package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.CompanyForm;
import com.codegym.finalproject.model.dto.request.EditCompany;
import com.codegym.finalproject.model.dto.request.StatusRequest;
import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.*;
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


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody EditCompany editCompany) {
        Account account = userDetailServices.getCurrentUser();
        if (account.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please login!"), HttpStatus.OK);
        }
        Optional<Company> company1 = companyService.findById(id);
        if (!company1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Boolean check = false;
        if (companyService.existByName(editCompany.getName())) {
            check = true;
        }

        if (editCompany.getAvatar() != null) {
            company1.get().setAvatar(editCompany.getAvatar());
        }
        if (editCompany.getName() != null) {
            company1.get().setName(editCompany.getName());
        }
        if (editCompany.getDescription() != null) {
            company1.get().setDescription(editCompany.getDescription());
        }
        if (editCompany.getAddress() != null) {
            company1.get().setAddress(editCompany.getAddress());
        }
        if (editCompany.getEmployeeQuantity() != null) {
            company1.get().setEmplployeeQuantity(editCompany.getEmployeeQuantity());
        }
        if (editCompany.getLinkMap() != null) {
            company1.get().setLinkMap(editCompany.getLinkMap());
        }
        if (editCompany.getPhone() != null) {
            company1.get().setPhone(editCompany.getPhone());
        }
        //tao codeCompany
        String nameex = company1.get().getName().substring(0, 3);
        int min = 1000;
        int max = 9999;
        String codeCompany = String.valueOf((int) Math.floor(Math.round((Math.random() * (max - min + 1) + min))));
        company1.get().setCodeCompany(nameex + company1.get().getAccount().getId() + codeCompany);
        companyService.save(company1.get());
        if (check == true) {
            return new ResponseEntity<>(new ResponseMessage("trung ten roi"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        if (companyService.existByName(company.getName())) {
            return new ResponseEntity<>(new ResponseMessage("this name is exist"), HttpStatus.OK);
        }
        //tao codeCompany
        String nameex = company.getName().substring(0, 3);
        int min = 1000;
        int max = 9999;
        String codeCompany = String.valueOf((int) Math.floor(Math.round((Math.random() * (max - min + 1) + min))));
        System.out.println(codeCompany);
        company.setCodeCompany(nameex + company.getAccount().getId() + codeCompany);
        company.setStatusCompany(Status.HOT);
        if (company.getAvatar() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_avatar_category"), HttpStatus.OK);
        }
        companyService.save(company);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
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

    @PutMapping("/change_status")
    public ResponseEntity<?> updateCompany1(@PathVariable Long id, @RequestBody StatusRequest statusRequest) {
        Account account = userDetailServices.getCurrentUser();
        if (account.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please login"), HttpStatus.OK);
        }
        Optional<Company> company1 = companyService.findById(id);
        if (!company1.isPresent()) {
            if (statusRequest.getStatus() == 1) {
                company1.get().setStatusCompany(Status.ACTIVE);
            }
            if (statusRequest.getStatus() == 2) {
                company1.get().setStatusCompany(Status.NON_ACTIVE);
            }
            if (statusRequest.getStatus() == 3) {
                company1.get().setStatusCompany(Status.LOCK);
            }
            if (statusRequest.getStatus() == 4) {
                company1.get().setStatusCompany(Status.UNLOCK);
            }
            if (statusRequest.getStatus() == 5) {
                company1.get().setStatusCompany(Status.HOT);
            }
            if (statusRequest.getStatus() == 6) {
                company1.get().setStatusCompany(Status.WAIT);
            }
            if (statusRequest.getStatus() == 7) {
                company1.get().setStatusCompany(Status.REJECT);
            }
            companyService.save(company1.get());
        }
        return new ResponseEntity<>(new ResponseMessage("Yes"), HttpStatus.OK);
    }

}
