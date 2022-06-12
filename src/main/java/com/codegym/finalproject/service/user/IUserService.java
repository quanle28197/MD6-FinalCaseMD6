package com.codegym.finalproject.service.user;

import com.codegym.finalproject.model.dto.request.UsernameAndPasswordUser;
import com.codegym.finalproject.model.entity.User;
import com.codegym.finalproject.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Optional<User> findByAccount_Id(Long id);

    Boolean existsByName(String name);

    UsernameAndPasswordUser findUsernameAndPassword(Long id);

}
