package com.codegym.finalproject.model.dto.response;

public class ResponeAccount {
    private String message;

    private Long id;

    public ResponeAccount(String message, Long id) {
        this.message = message;
        this.id = id;
    }

    public ResponeAccount() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
