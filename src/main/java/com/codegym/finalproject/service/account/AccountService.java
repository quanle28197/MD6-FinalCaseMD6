package com.codegym.finalproject.service.account;

import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
