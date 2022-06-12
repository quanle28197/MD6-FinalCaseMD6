package com.codegym.finalproject.model.dto.request;

public class ForwardApply {
    private Long idUser;
    private Long idCompany;

    public ForwardApply(Long idUser, Long idCompany) {
        this.idUser = idUser;
        this.idCompany = idCompany;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }
}
