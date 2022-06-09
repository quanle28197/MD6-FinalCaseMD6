package com.codegym.finalproject.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
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

}
