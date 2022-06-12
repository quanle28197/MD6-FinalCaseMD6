package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Long> {
    Iterable<Skill> findAllByCv_Id(Long id);
    Boolean existsByCv_Id(Long id);
    boolean existsById(Long id);
}
