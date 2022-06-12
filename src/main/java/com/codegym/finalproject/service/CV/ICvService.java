package com.codegym.finalproject.service.CV;

import com.codegym.finalproject.model.entity.CV;
import com.codegym.finalproject.service.IGeneralService;

import java.util.Optional;

public interface ICvService extends IGeneralService<CV> {
    Boolean existByUserId(Long idUser);

    Optional<CV> findByUserId(Long id);
}
