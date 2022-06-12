package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Long> {
    Iterable<Skill> findAllByCv_Id(Long id);
    Boolean existByCv_Id(Long id);
    boolean existById(Long id);
}
