package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "workingtime")
public class WorkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = RecuitmentNew.class, mappedBy = "workingTime")
    @JsonIgnore
    private List<RecuitmentNew> recuitmentNews;
}
