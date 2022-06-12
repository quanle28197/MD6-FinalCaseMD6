package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacanciesRepository extends JpaRepository<Vacancies, Long> {
}
