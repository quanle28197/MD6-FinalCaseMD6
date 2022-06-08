package com.codegym.finalproject.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "apply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = RecuitmentNew.class)
    private RecuitmentNew recuitmentNew;

    @Enumerated(EnumType.STRING)
    @NaturalId(mutable=true)
    private Status status;

    private LocalDate date;
}
