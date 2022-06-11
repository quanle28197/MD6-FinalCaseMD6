package com.codegym.finalproject;

import com.codegym.finalproject.model.entity.Role;
import com.codegym.finalproject.model.entity.RoleName;
import com.codegym.finalproject.model.entity.User;
import com.codegym.finalproject.service.role.RoleService;
import com.codegym.finalproject.service.user.UserService;
import org.apache.catalina.authenticator.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;



    @Override
    public void run(String... args) throws Exception {
        if (!roleService.findByName(RoleName.USER).isPresent()) {
            roleService.save(new Role(RoleName.USER));
            System.out.println("INSERT ROLE USER");
        }
        if (!roleService.findByName(RoleName.COMPANY).isPresent()) {
            roleService.save(new Role(RoleName.COMPANY));
            System.out.println("INSERT ROLE COMPANY");
        }
    }
}
