package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecruitmentNewRepository extends JpaRepository<RecuitmentNew, Long> {
    List<RecuitmentNew> findAllByCompany_Id(Long id);
}
