package com.codegym.finalproject.service.company;

import com.codegym.finalproject.model.entity.Company;
import com.codegym.finalproject.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ICompanyService extends IGeneralService<Company> {
    Optional<Company> findAllByAccount_Id(Long id);

    Boolean existByName(String name);

    List<Company> findCompanyByStatus(Integer stt);
}
