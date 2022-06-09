package com.codegym.finalproject.service;

import com.codegym.finalproject.model.entity.CV;
import com.codegym.finalproject.repository.ICVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class CVService implements ICvService {

    @Autowired
    ICVRepository icvRepository;

    @Override
    public Boolean existByUserId(Long idUser) {
        return icvRepository.existByUserId(idUser);
    }

    @Override
    public Optional<CV> findByUserId(Long id) {
        return icvRepository.findByUserId(id);
    }

    @Override
    public Iterable<CV> findAll() {
        return icvRepository.findAll();
    }

    @Override
    public Page<CV> findAll(Pageable pageable) {
        return icvRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        icvRepository.deleteById(id);
    }

    @Override
    public CV save(CV cv) {
        return icvRepository.save(cv);
    }

    @Override
    public Optional<CV> findById(Long id) {
        return icvRepository.findById(id);
    }
}
