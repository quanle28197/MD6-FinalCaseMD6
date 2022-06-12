package com.codegym.finalproject.service;

import com.codegym.finalproject.model.dto.response.ApplyShowAll;
import com.codegym.finalproject.model.entity.Apply;
import com.codegym.finalproject.repository.IApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ApplyService implements IApplyService {
    @Autowired
    IApplyRepository applyRepository;
    @Override
    public Iterable<Apply> findAll() {
        return applyRepository.findAll();
    }

    @Override
    public Page<Apply> findAll(org.springframework.data.domain.Pageable pageable) {
        return applyRepository.findAll(pageable);
    }


    @Override
    public void deleteById(Long id) {
        applyRepository.deleteById(id);
    }

    @Override
    public Apply save(Apply apply) {
        return applyRepository.save(apply);
    }

    @Override
    public Optional<Apply> findById(Long id) {
        return applyRepository.findById(id);
    }

    @Override
    public Page<ApplyShowAll> findAllByCompanyId(Pageable page, Long id) {
        return applyRepository.findAllByCompanyId(page,id);
    }

    @Override
    public Page<Apply> findAllByUserId(Pageable pageable, Long id) {
        return applyRepository.findAllByUser_Id(pageable,id);
    }

    @Override
    public boolean existsByUserIdAndRecuitmentNewId(Long userID, Long recuitmentID) {
        return applyRepository.existsByUserIdAndRecuitmentNewId(userID,recuitmentID);
    }
}
