package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkingTimeRepository extends JpaRepository<WorkingTime, Long> {
}
