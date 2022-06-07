package com.codegym.finalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @NaturalId(mutable = true)
    private Status status;
    private Boolean status2;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public Account(Long id, String username, String password, Status status, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public Account(Long id, String username, String password, Status status, Boolean status2, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.status2 = status2;
        this.roles = roles;
    }

    public Account(String username, String password, Status status, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public Account(String username, String password, Status status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getStatus2() {
        return status2;
    }

    public void setStatus2(Boolean status2) {
        if (status.equals(Status.NON_ACTIVE)) {
            this.status2 = false;
        } else {
            this.status2 = true;
        }
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
