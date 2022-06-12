package com.codegym.finalproject.service.recuitmentNew;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.repository.IRecruitmentNewRepository;
import com.codegym.finalproject.repository.IRecuitmentnewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RecruitmentNewService implements IRecuitmentNewService {
    @Autowired
    IRecruitmentNewRepository recruitmentNewRepository;

    @Autowired
    IRecuitmentnewDAO recruitmentNewDAO;

    @Override
    public Iterable<RecuitmentNew> findAll() {
        return recruitmentNewRepository.findAll();
    }

    @Override
    public Page<RecuitmentNew> findAll(Pageable pageable) {
        return recruitmentNewRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        recruitmentNewRepository.deleteById(id);
    }

    @Override
    public RecuitmentNew save(RecuitmentNew recuitmentNew) {
        return recruitmentNewRepository.save(recuitmentNew);
    }

    @Override
    public Optional<RecuitmentNew> findById(Long id) {
        return recruitmentNewRepository.findById(id);
    }

    @Override
    public List<RecuitmentNew> findAllByCompany_Id(Long id) {
        return recruitmentNewRepository.findAllByCompany_Id(id);
    }

    @Override
    public List<RecuitmentNew> search(SearchJob searchJob) {
        if (searchJob.getTitle().equals("")) {
            return new ArrayList<>();
        } else {
            return recruitmentNewRepository.search(searchJob.getTitle());
        }
    }
}
