package com.codegym.finalproject.service;

import com.codegym.finalproject.model.entity.CV;

import java.util.Optional;

public interface ICvService extends IGeneralService<CV>{
    Boolean existByUserId(Long idUser);

    Optional<CV> findByUserId(Long id);
}
