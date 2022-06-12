package com.codegym.finalproject.service.skill;

import com.codegym.finalproject.model.entity.Skill;
import com.codegym.finalproject.service.IGeneralService;

public interface ISkillService extends IGeneralService<Skill> {
    Iterable<Skill> findAllSkillsByCvId(Long id);
    Boolean existsByCv_Id(Long id);
    boolean existsById(Long id);
}
