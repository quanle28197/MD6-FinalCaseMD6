package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    @ManyToOne(targetEntity = Company.class)
    private Company company;
    @ManyToOne(targetEntity = Vacancies.class)
    private Vacancies vacancies;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date expDate;

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
