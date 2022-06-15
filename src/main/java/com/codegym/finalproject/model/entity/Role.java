package com.codegym.finalproject.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.authenticator.Constants;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;



    public Role(RoleName name) {
        this.name = name;
    }


}
