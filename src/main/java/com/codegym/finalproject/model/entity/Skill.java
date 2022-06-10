package com.codegym.finalproject.model.entity;

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

}
