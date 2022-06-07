package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "vacancies")
public class Vacancies {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(targetEntity = RecuitmentNew.class, mappedBy = "vacancies")
    @JsonIgnore
    private List<RecuitmentNew> recuitmentNews;
}
