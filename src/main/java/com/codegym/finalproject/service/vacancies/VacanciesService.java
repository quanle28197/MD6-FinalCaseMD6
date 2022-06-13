package com.codegym.finalproject.service.vacancies;

import com.codegym.finalproject.model.entity.Vacancies;
import com.codegym.finalproject.repository.IVacanciesReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacanciesService implements IVacanciesService{
    @Autowired
    private IVacanciesReposiroty vacanciesReposiroty;

    @Override
    public Iterable<Vacancies> findAll() {
        return vacanciesReposiroty.findAll();
    }

    @Override
    public Page<Vacancies> findAll(Pageable pageable) {
        return vacanciesReposiroty.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        vacanciesReposiroty.deleteById(id);
    }

    @Override
    public Vacancies save(Vacancies vacancies) {
        return vacanciesReposiroty.save(vacancies);
    }

    @Override
    public Optional<Vacancies> findById(Long id) {
        return vacanciesReposiroty.findById(id);
    }
}
