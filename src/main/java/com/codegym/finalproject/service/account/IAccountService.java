package com.codegym.finalproject.service.account;

import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IAccountService extends IGeneralService<Account> {
    Optional<Account> findByUsername(String name);

    Boolean existsByUsername(String username);
}
