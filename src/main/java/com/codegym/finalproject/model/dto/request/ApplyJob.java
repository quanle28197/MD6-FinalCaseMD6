package com.codegym.finalproject.model.dto.request;

public class ApplyJob {
    private Long recuitmentNewId;
    private Long userId;

    public ApplyJob(Long recuitmentNewId, Long userId) {
        this.recuitmentNewId = recuitmentNewId;
        this.userId = userId;
    }

    public Long getRecuitmentNewId() {
        return recuitmentNewId;
    }

    public void setRecuitmentNewId(Long recuitmentNewId) {
        this.recuitmentNewId = recuitmentNewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
