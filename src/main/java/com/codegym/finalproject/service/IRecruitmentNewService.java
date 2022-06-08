package com.codegym.finalproject.service;

import com.codegym.finalproject.model.entity.RecuitmentNew;

import java.util.List;

public interface IRecruitmentNewService extends IGeneralService<RecuitmentNew> {
    List<RecuitmentNew> findAllbyCompany_Id(Long id);
}
