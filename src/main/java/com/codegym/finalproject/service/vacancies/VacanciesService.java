package com.codegym.finalproject.service.vacancies;

import com.codegym.finalproject.model.entity.Vacancies;
import com.codegym.finalproject.repository.IVacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacanciesService implements IVacanciesService {


    @Autowired
    private IVacanciesRepository vacanciesRepository;


    @Override
    public Iterable<Vacancies> findAll() {
        return vacanciesRepository.findAll();
    }

    @Override
    public Page<Vacancies> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Vacancies save(Vacancies vacancies) {
        return null;
    }

    @Override
    public Optional<Vacancies> findById(Long id) {
        return Optional.empty();
    }
}
