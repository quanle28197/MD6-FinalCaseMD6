package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecuitmentNewRepository extends JpaRepository<RecuitmentNew, Long> {
}
