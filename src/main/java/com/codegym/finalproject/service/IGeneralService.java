package com.codegym.finalproject.service;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void removeById(Long id);
}
