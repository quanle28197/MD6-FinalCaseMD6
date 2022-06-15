package com.codegym.finalproject.service.account;

import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.model.entity.Role;
import com.codegym.finalproject.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Optional<Account> findByUsername(String name) {
        return accountRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }


    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
}
