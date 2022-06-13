package com.codegym.finalproject.controller;


import com.codegym.finalproject.model.dto.request.ApplyJob;
import com.codegym.finalproject.model.dto.request.ForwardApply;
import com.codegym.finalproject.model.dto.response.ApplyShowAll;
import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.*;
import com.codegym.finalproject.service.CV.ICvService;
import com.codegym.finalproject.service.apply.IApplyService;
import com.codegym.finalproject.service.company.CompanyService;
import com.codegym.finalproject.service.email.EmailServiceImpl;
import com.codegym.finalproject.service.recuitmentNew.IRecuitmentNewService;
import com.codegym.finalproject.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    private ICvService cvService;

    @Autowired
    private EmailServiceImpl emailService;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping
    public ResponseEntity<?> createApply(@RequestBody ApplyJob applyJob) {
        System.out.println(applyService.existsByUserIdAndRecuitmentNewId(applyJob.getUserId(),applyJob.getRecuitmentNewId()));
        if(applyService.existsByUserIdAndRecuitmentNewId(applyJob.getUserId(),applyJob.getRecuitmentNewId())){
            return new ResponseEntity<>(new ResponseMessage("MATCH"), HttpStatus.OK);
        }
        if(cvService.existByUserId(applyJob.getUserId())){
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
    @PostMapping("/forward")
    public ResponseEntity<?> forwardApply(@RequestBody ForwardApply forwardApply){
        Company companyCurrent = companyService.findById(forwardApply.getIdCompany()).get();
        User userCurrent = userService.findById(forwardApply.getIdUser()).get();
        MailObject mailObject = new MailObject(from,userCurrent.getAccount().getUsername(), "Thông báo tuyển dụng", "Bạn " + userCurrent.getName() + " đã ứng tuyển vào công ty " +companyCurrent.getName() + " thành công. Vui lòng chờ mail từ công ty để xác nhận" );
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @PostMapping("/forwardSuccess")
    public ResponseEntity<?> forwardApplySuccess(@RequestBody ForwardApply forwardApply){
        Company companyCurrent = companyService.findById(forwardApply.getIdCompany()).get();
        User userCurrent = userService.findById(forwardApply.getIdUser()).get();
        LocalDate dateApply = LocalDate.now().plusDays(3) ;
        MailObject mailObject = new MailObject(from,userCurrent.getAccount().getUsername(), "Thông báo tuyển dụng", "Công ty " + companyCurrent.getName() + " đã chấp nhận đơn ứng tuyển của bạn " + userCurrent.getName() + ". Lịch phỏng vấn của bạn với công ty vào ngày " + dateApply +". Hãy liên hệ với công ty bạn ứng tuyển để biết thêm chi tiết !!");
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/findAllByCompanyID/{id}")
    public ResponseEntity<?> findAllByCompany(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable, @PathVariable Long id) {
        Page<ApplyShowAll> list = applyService.findAllByCompanyId(pageable, id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/showAllApply/{id}")
    public ResponseEntity<?>showAllApplyById(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,@PathVariable Long id){
        Page<Apply> list = applyService.findAllByUserId(pageable,id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/changeStatusApply")
    public ResponseEntity<?> changeStatusApply(@RequestBody ChangeStatusApply changeStatusApply ){
        Apply apply = applyService.findById(changeStatusApply.getId()).get();
        boolean check = false;
        List<Apply> applyList = (List<Apply>) applyService.findAll();
        for (Apply apply1 : applyList ) {
            if(apply1.getUser().getId() == apply.getUser().getId() && apply1.getRecuitmentNew().getCompany().getId() == apply.getRecuitmentNew().getCompany().getId()){
                String statusold = String.valueOf(apply1.getStatus());
                System.out.println(Status.ACCEPT);
                System.out.println(statusold);
                if(statusold.equals("APCEPT")){
                    check = true;
                }
            }
        }
        if(changeStatusApply.getStatus() == 1){
            if(check){
                return new ResponseEntity<>(new ResponseMessage("Nhân viên đã được apcept bởi công ty khác"), HttpStatus.OK);
            }
            apply.setStatus(Status.ACCEPT);
            applyService.save(apply);
            Company companyCurrent = apply.getRecuitmentNew().getCompany();
            User userCurrent = apply.getUser();
            LocalDate dateApply = LocalDate.now().plusDays(3) ;
            MailObject mailObject = new MailObject("findJob@job.com",userCurrent.getAccount().getUsername(), "Thông báo tuyển dụng", "Công ty " + companyCurrent.getName() + " đã chấp nhận đơn ứng tuyển của bạn " + userCurrent.getName() + ". Lịch phỏng vấn của bạn với công ty vào ngày " + dateApply +". Hãy liên hệ với công ty bạn ứng tuyển để biết thêm chi tiết !!");
            emailService.sendSimpleMessage(mailObject);
            return new ResponseEntity<>(new ResponseMessage("Nhân viên đã được apcept thành công"), HttpStatus.OK);

        }
        if(changeStatusApply.getStatus() == 0){
            apply.setStatus(Status.REJECT);
            applyService.save(apply);
            Company companyCurrent = apply.getRecuitmentNew().getCompany();
            User userCurrent = apply.getUser();
            MailObject mailObject = new MailObject("findJob@job.com",userCurrent.getAccount().getUsername(), "Thông báo tuyển dụng", "Công ty " + companyCurrent.getName() + " đã từ chối đơn ứng tuyển của bạn " + userCurrent.getName() + ". Chúc bạn may mắn lần sau ");
            emailService.sendSimpleMessage(mailObject);
            return new ResponseEntity<>(new ResponseMessage("Bạn đã từ chối thành công"), HttpStatus.OK);

        }
        if(changeStatusApply.getStatus() == 2){
            apply.setStatus(Status.WAIT);
            applyService.save(apply);
            return new ResponseEntity<>(new ResponseMessage("Bạn đã đổi trạng thái thành công"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ResponseMessage("Bạn đã đổi trạng thái thất bại"), HttpStatus.OK);
        }
    }
}
