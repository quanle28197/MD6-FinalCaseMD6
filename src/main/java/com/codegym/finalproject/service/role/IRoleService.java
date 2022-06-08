package com.codegym.finalproject.service.role;

import com.codegym.finalproject.model.entity.Role;
import com.codegym.finalproject.model.entity.RoleName;
import com.codegym.finalproject.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IRoleService extends IGeneralService<Role> {
    Optional<Role> findByName(RoleName name);
}
