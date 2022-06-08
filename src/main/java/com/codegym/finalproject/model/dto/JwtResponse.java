package com.codegym.finalproject.model.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long idAccount;

    private Long idGuest;

    private String token;

    private String type = "Bearer";

    private String username;

    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse() {
    }

    public JwtResponse(Long idAccount, Long idGuest, String token, String username, Collection<? extends GrantedAuthority> roles) {
        this.idAccount = idAccount;
        this.idGuest = idGuest;
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Long idGuest) {
        this.idGuest = idGuest;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
