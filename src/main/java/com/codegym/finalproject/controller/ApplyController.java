package com.codegym.finalproject.controller;


import com.codegym.finalproject.model.dto.request.ApplyJob;
import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.Apply;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.model.entity.Status;
import com.codegym.finalproject.model.entity.User;
import com.codegym.finalproject.service.CV.ICvService;
import com.codegym.finalproject.service.IApplyService;
import com.codegym.finalproject.service.company.CompanyService;
import com.codegym.finalproject.service.email.EmailServiceImpl;
import com.codegym.finalproject.service.recuitmentNew.IRecuitmentNewService;
import com.codegym.finalproject.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/applies")
public class ApplyController {
    @Autowired
    private IApplyService applyService;

    @Autowired
    private IRecuitmentNewService recuitmentNewService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ICvService iCvService;

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping
    public ResponseEntity<?> createApply(@RequestBody ApplyJob applyJob) {
        System.out.println(applyService.existsByUserIdAndRecuitmentNewId(applyJob.getUserId(),applyJob.getRecuitmentNewId()));
        if(applyService.existsByUserIdAndRecuitmentNewId(applyJob.getUserId(),applyJob.getRecuitmentNewId())){
            return new ResponseEntity<>(new ResponseMessage("MATCH"), HttpStatus.OK);
        }
        if(iCvService.existByUserId(applyJob.getUserId())){
            LocalDate now = LocalDate.now();
            RecuitmentNew recuitmentNew = recuitmentNewService.findById(applyJob.getRecuitmentNewId()).get();
            User user = userService.findById(applyJob.getUserId()).get();
            Apply apply = new Apply();
            apply.setDate(now);
            apply.setStatus(Status.WAIT);
            apply.setUser(user);
            apply.setRecuitmentNew(recuitmentNew);
            applyService.save(apply);
            return new ResponseEntity<>(new ResponseMessage("CREATE"), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(new ResponseMessage("CREATE_FAIL"), HttpStatus.OK);
        }
    }
}
