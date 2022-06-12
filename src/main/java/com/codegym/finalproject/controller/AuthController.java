package com.codegym.finalproject.controller;

import com.codegym.finalproject.model.dto.request.ChangePassword;
import com.codegym.finalproject.model.dto.request.SignInForm;
import com.codegym.finalproject.model.dto.request.SignUpForm;
import com.codegym.finalproject.model.dto.response.JwtResponse;
import com.codegym.finalproject.model.dto.response.ResponeAccount;
import com.codegym.finalproject.model.dto.response.ResponseBody;
import com.codegym.finalproject.model.dto.response.ResponseMessage;
import com.codegym.finalproject.model.entity.*;
import com.codegym.finalproject.security.jwt.JwtProvider;
import com.codegym.finalproject.security.userprincipal.UserDetailServices;
import com.codegym.finalproject.security.userprincipal.UserPrinciple;
import com.codegym.finalproject.service.email.EmailServiceImpl;
import com.codegym.finalproject.service.account.AccountService;
import com.codegym.finalproject.service.role.RoleService;
import com.codegym.finalproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailServices userDetailServices;

    @Autowired
    UserService userService;

    @Autowired
    EmailServiceImpl emailService;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (accountService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponeAccount("no_user", -1L), HttpStatus.OK);
        }
        String passwordOld = signUpForm.getPassword();
        Account account = new Account(signUpForm.getUsername(), passwordEncoder.encode(passwordOld));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "company":
                    Role pmRole = roleService.findByName(RoleName.COMPANY).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    int min = 10000000;
                    int max = 99999999;
                    String passwordNew = String.valueOf((int) Math.floor(Math.round((Math.random() * (max - min + 1) + min))));
                    account.setPassword(passwordEncoder.encode(passwordNew));
                    MailObject mailObject = new MailObject(from, account.getUsername(), "Hello from Find Job", "Your account is" + " \nusername:" + account.getUsername() + "\npassword: " + passwordNew);
                    emailService.sendSimpleMessage(mailObject);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(() -> new RuntimeException("Role not found"));
                    MailObject mailObject1 = new MailObject(from, account.getUsername(), "Hello from Find Job", "Your account is: username: " + account.getUsername() + "\npassword: " + passwordOld);
                    emailService.sendSimpleMessage(mailObject1);
                    roles.add(userRole);
            }
        });

        account.setRoles(roles);
        account.setStatus(Status.NON_ACTIVE);
        accountService.save(account);
        return new ResponseEntity<>(new ResponeAccount("Yes", account.getId()), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.createToken(authentication);
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            Long id = ((UserPrinciple) authentication.getPrincipal()).getId();
            String a = authentication.getAuthorities().toString();
            Long idCustom = -1L;

            if (userPrinciple.getStatus().equalsIgnoreCase(String.valueOf(Status.NON_ACTIVE))) {
                return new ResponseEntity<>(new ResponseBody("0002", "Tài khoản chưa kích hoạt. Vui lòng kích hoạt tài khoản trước!", null), HttpStatus.OK);
            }
            if (a.equals("[USER]")) {
                Optional<User> user = userService.findByAccount_Id(id);
                idCustom = user.get().getId();
            }
            if (a.equals("[ADMIN]")) {
                idCustom = -10L;
            }
            return ResponseEntity.ok(new ResponseBody("0000", "success", new JwtResponse(id, idCustom, token, userPrinciple.getUsername(), userPrinciple.getAuthorities())));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseBody("0001", "Bạn nhập sai tài khoản hoặc mật khẩu!", null), HttpStatus.OK);
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword changePassword) {
        Account account = userDetailServices.getCurrentUser();
        if (account.getUsername().equals("Anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please login"), HttpStatus.OK);
        }
        account.setPassword(passwordEncoder.encode(changePassword.getPassword()));
        accountService.save(account);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Account> account = accountService.findById(id);
        System.out.println(account.get().getStatus());
        if (!account.isPresent()) {
            return new ResponseEntity<>(new ResponseMessage("User is not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account.get().getStatus(), HttpStatus.OK);
    }

    @GetMapping("/showAllAccount")
    public ResponseEntity<?> showAllAccount() {
        List<Account> accounts = (List<Account>) accountService.findAll();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getStatus().equals(Status.NON_ACTIVE)) {
                accounts.get(i).setStatus2(false);
            } else {
                accounts.get(i).setStatus2(true);
            }
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/verify/{id}")
    public ResponseEntity<Account> verifyAccount(@PathVariable Long id) {
        Optional<Account> account = accountService.findById(id);
        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account.get().setStatus(Status.ACTIVE);
        accountService.save(account.get());
        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }
}
