package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "recuitmentnew")
public class RecuitmentNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeNews;

    private String title;
    @ManyToOne(targetEntity = WorkingTime.class)
    private WorkingTime workingTime;
    @ManyToOne(targetEntity = Field.class)
    private Field field;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne(targetEntity = Vacancies.class)
    private Vacancies vacancies;

    private LocalDate expDate;

    private String description;

    private Integer quantity;

    private Integer salary;

    private int gender;

    @ManyToOne(targetEntity = City.class)
    private City city;

    private Boolean status;

    @OneToMany(targetEntity = Apply.class, mappedBy = "recuitmentNew")
    @JsonIgnore
    private List<Apply> applies;
}
