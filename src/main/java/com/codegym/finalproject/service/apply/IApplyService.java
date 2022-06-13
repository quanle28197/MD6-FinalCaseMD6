package com.codegym.finalproject.service.apply;


import com.codegym.finalproject.model.dto.response.ApplyShowAll;
import com.codegym.finalproject.model.entity.Apply;
import com.codegym.finalproject.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IApplyService  extends IGeneralService<Apply> {
    Page<ApplyShowAll> findAllByCompanyId(Pageable page, @Param("idCompany") Long id);
    Page<Apply> findAllByUserId(Pageable pageable, Long id);

    Page<ApplyShowAll> findAllByCompanyId(java.awt.print.Pageable page, Long id);

    boolean existsByUserIdAndRecuitmentNewId(Long userID, Long recuitmentID);

}
