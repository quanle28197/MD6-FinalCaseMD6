package com.codegym.finalproject.service;

import com.codegym.finalproject.model.dto.response.ApplyShowAll;
import com.codegym.finalproject.model.entity.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface IApplyService  extends IGeneralService<Apply> {
    Page<ApplyShowAll> findAllByCompanyId(Pageable page, @Param("idCompany") Long id);
    Page<Apply> findAllByUserId(Pageable pageable, Long id);
    boolean existsByUserIdAndRecuitmentNewId(Long userID, Long recuitmentID);

}
