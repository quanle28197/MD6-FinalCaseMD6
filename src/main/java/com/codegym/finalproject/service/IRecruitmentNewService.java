package com.codegym.finalproject.service;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRecruitmentNewService extends IGeneralService<RecuitmentNew> {
    List<RecuitmentNew> findAllbyCompany_Id(Long id);

//    PageResponse searchByObj(SearchJob searchJob);
}
