package com.codegym.finalproject.service.CV;

import com.codegym.finalproject.model.entity.CV;
import com.codegym.finalproject.repository.ICVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CVService implements ICvService {
    @Autowired
    ICVRepository icvRepository;

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

    @Override
    public Boolean existByUserId(Long idUser) {
        return icvRepository.existsByUserId(idUser);
    }

    @Override
    public Optional<CV> findByUserId(Long id) {
        return icvRepository.findByUserId(id);
    }
}
