package com.codegym.finalproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeCompany;

    private String name;

    private String avatar;

    private String description;

    private String address;

    private int emplployeeQuantity;

    @ManyToOne(targetEntity = City.class)
    private City city;

    private String linkMap;

    private String phone;

    private Status statusCompany;

    @OneToOne
    private Account account;

    @OneToMany(targetEntity = RecuitmentNew.class, mappedBy = "company")
    @JsonIgnore
    private List<RecuitmentNew> recuitmentNews;


    public Company(String codeCompany, String name, String avatar, String description, String address, int emplployeeQuantity, City city, String linkMap, String phone, Status statusCompany, Account account, List<RecuitmentNew> recuitmentNews) {
        this.codeCompany = codeCompany;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.address = address;
        this.emplployeeQuantity = emplployeeQuantity;
        this.city = city;
        this.linkMap = linkMap;
        this.phone = phone;
        this.statusCompany = statusCompany;
        this.account = account;
        this.recuitmentNews = recuitmentNews;
    }
}
