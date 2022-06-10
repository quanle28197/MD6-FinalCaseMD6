package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    //    Tim kiem user co ton tai trong db khong
    Optional<Account> findByUsername(String name);

    //    username da ton tai trong db chua
    Boolean existsByUsername(String username);
}
