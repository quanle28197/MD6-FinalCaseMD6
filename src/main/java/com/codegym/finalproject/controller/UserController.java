package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.model.entity.MailObject;
import com.codegym.finalproject.model.entity.User;
import com.codegym.finalproject.security.userprincipal.UserDetailServices;
import com.codegym.finalproject.service.account.AccountService;
import com.codegym.finalproject.service.email.EmailServiceImpl;
import com.codegym.finalproject.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RestController

public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserDetailServices userDetailServices;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    AccountService accountService;

    @Value("${spring.mail.username}")
    private String from;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return  new ResponseEntity<>(new ResponseMessage("No mact found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if (user.getName() == null) {
            return new ResponseEntity<>(new ResponseMessage("name is null"), HttpStatus.OK);
        }
        User user1 = userService.save(user);
        Account account = accountService.findById(user.getAccount().getId()).get();
        MailObject mailObject = new MailObject(from, account.getUsername(),"Your account is verify", "Submit to verify your account: " + "\n http://localhost:4200/active-status/"+account.getId());
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(new ResponseMessage("oki dude"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        Account account = userDetailServices.getCurrentUser();
        if (account.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please login!"), HttpStatus.OK);
        }
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userOptional.get().setName(user.getName());
        userOptional.get().setPhone(user.getPhone());
        userService.save(userOptional.get());
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("oki dude"), HttpStatus.OK);
    }
}
