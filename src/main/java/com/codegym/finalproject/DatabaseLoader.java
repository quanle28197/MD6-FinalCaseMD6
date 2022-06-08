package com.codegym.finalproject;

import com.codegym.finalproject.model.entity.Role;
import com.codegym.finalproject.model.entity.RoleName;
import com.codegym.finalproject.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private RoleService roleService;


    @Override
    public void run(String... args) throws Exception {
        if (!roleService.findByName(RoleName.USER).isPresent()) {
            roleService.save(new Role(RoleName.USER));
            System.out.println("INSERT ROLE USER");
        }

    }
}
