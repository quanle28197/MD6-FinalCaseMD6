package com.codegym.finalproject.model.entity;

import com.codegym.finalproject.model.dto.request.SkillDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String proficiency;

    @ManyToOne(targetEntity = CV.class)
    private CV cv;

    public SkillDTO toDto(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.name);
        skillDTO.setProficiency(skill.proficiency);
        skillDTO.setCvId(skill.getCv().getId());
        return skillDTO;
    }

    public Skill toEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setId(skillDTO.getId());
        skill.setName(skillDTO.getName());
        skill.setProficiency(skill.getProficiency());
        CV cv = new CV();
        cv.setId(skillDTO.getId());
        skill.setCv(cv);
        return skill;
    }

}
