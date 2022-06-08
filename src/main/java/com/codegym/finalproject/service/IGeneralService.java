package com.codegym.finalproject.service;

import com.codegym.finalproject.model.entity.City;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
