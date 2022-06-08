package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Company.class, mappedBy = "city")
    @JsonIgnore
    private List<Company> companies;

    @OneToMany(targetEntity = RecuitmentNew.class, mappedBy = "city")
    @JsonIgnore
    private List<RecuitmentNew> recuitmentNews;

}
