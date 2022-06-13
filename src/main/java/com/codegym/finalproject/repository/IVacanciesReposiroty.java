package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacanciesReposiroty extends JpaRepository<Vacancies, Long> {
}
