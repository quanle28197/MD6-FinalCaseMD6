package com.codegym.finalproject.model.entity;

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
  }
