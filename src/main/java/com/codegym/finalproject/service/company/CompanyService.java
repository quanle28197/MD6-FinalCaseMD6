package com.codegym.finalproject.service.company;

import com.codegym.finalproject.model.entity.Company;
import com.codegym.finalproject.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> findAllByAccount_Id(Long id) {
        return companyRepository.findAllByAccount_Id(id);
    }

    @Override
    public Boolean existByName(String name) {
        return companyRepository.existsByName(name);
    }

    @Override
    public List<Company> findCompanyByStatus(Integer stt) {
        return companyRepository.findCompanyByStatus(stt);
    }
}
