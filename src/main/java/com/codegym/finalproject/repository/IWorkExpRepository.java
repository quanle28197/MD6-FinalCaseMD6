package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkExpRepository extends JpaRepository<WorkExp, Long> {
    Iterable<WorkExp> findAllByCv_Id(Long id);
    Boolean existByCv_Id(Long id);
}
