package com.codegym.finalproject.model.entity;


import com.codegym.finalproject.model.dto.request.CvDTO;
import com.codegym.finalproject.model.dto.request.SkillDTO;
import com.codegym.finalproject.model.dto.request.WorkExpDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cv")
@Data
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private int expYear;

    private Double salaryExpectation;

    private String fileCV;

    @OneToMany(targetEntity = Skill.class, fetch = FetchType.EAGER, mappedBy = "cv")
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Skill> skills;

    @OneToMany(targetEntity = WorkExp.class, fetch = FetchType.EAGER, mappedBy = "cv")
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<WorkExp> workExps;

    public CvDTO toDto(CV cv) {
        CvDTO cvDTO = new CvDTO();
        cvDTO.setId(cv.id);
        cvDTO.setUsername(cv.user.getAccount().getUsername());
        cvDTO.setSalaryExpectation(cv.salaryExpectation);
        cvDTO.setExpYear(cv.expYear);
        cvDTO.setFileCV(cv.fileCV);
        cvDTO.setUserId(cv.user.getId());
        cvDTO.setFullName(cv.user.getName());
        cvDTO.setPhone(cv.getUser().getPhone());

        List<Skill> skills = cv.getSkills();
        List<SkillDTO> skillDTOS = new ArrayList<>();
        if (!skills.isEmpty()) {
            for (Skill s : skills
            ) {
                SkillDTO skillDTO = s.toDto(s);
                skillDTOS.add(skillDTO);
            }
        }
        cvDTO.setSkills(skillDTOS);

        List<WorkExp> workExps = cv.getWorkExps();
        List<WorkExpDTO> workExpDTOS = new ArrayList<>();
        if (!workExps.isEmpty()) {
            for (WorkExp w : workExps) {
                WorkExpDTO workExpDTO = w.toDto(w);
                workExpDTOS.add(workExpDTO);
            }
        }
        cvDTO.setWorkExps(workExpDTOS);
        return cvDTO;
    }

    public CV toEntity(CvDTO cvDTO) {
        CV cv = new CV();
        cv.setSalaryExpectation(cvDTO.getSalaryExpectation());
        cv.setExpYear(cvDTO.getExpYear());
        cv.setFileCV(cvDTO.getFileCV());
        return cv;
    }

}
