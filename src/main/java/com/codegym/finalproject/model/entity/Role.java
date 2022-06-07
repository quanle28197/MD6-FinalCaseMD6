package com.codegym.finalproject.model.entity;


import com.codegym.finalproject.model.entity.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;
}
