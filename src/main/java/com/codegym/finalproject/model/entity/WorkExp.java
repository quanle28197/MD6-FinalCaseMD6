package com.codegym.finalproject.model.entity;

import com.codegym.finalproject.model.dto.request.WorkExpDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workexp")
@Data
public class WorkExp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = CV.class)
    private CV cv;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private String content;

    public WorkExpDTO toDto(WorkExp workExp) {
        WorkExpDTO workExpDTO = new WorkExpDTO();
        workExpDTO.setId(workExp.getId());
        workExpDTO.setContent(workExp.getContent());
        workExpDTO.setStartDate(workExp.getStartDate());
        workExpDTO.setEndDate(workExp.getEndDate());
        workExpDTO.setTitle(workExp.getTitle());
        workExpDTO.setCvId(workExp.getCv().getId());
        return workExpDTO;
    }

    public WorkExp toEntity(WorkExpDTO workExpDTO) {
        WorkExp workExp = new WorkExp();
        workExp.setId(workExpDTO.getId());
        workExp.setContent(workExpDTO.getContent());
        workExp.setTitle(workExpDTO.getTitle());
        workExp.setStartDate(workExpDTO.getStartDate());
        workExp.setEndDate(workExpDTO.getEndDate());
        CV cv = new CV();
        cv.setId(workExpDTO.getId());
        workExp.setCv(cv);
        return workExp;
    }
  }
