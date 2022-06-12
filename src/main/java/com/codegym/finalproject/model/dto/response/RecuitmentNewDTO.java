package com.codegym.finalproject.model.dto.response;

public class RecuitmentNewDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long cityId;
    private String cityName;
    private Long companyId;
    private String companyName;
    private Long fieldId;
    private String fieldName;
    private Long vacanciesId;
    private String vacanciesName;
    private Long workingTimeId;
    private String workingTimeName;
    private String avatar;
    private Integer salary;
    private String expDate;

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getVacanciesId() {
        return vacanciesId;
    }

    public void setVacanciesId(Long vacanciesId) {
        this.vacanciesId = vacanciesId;
    }

    public Long getWorkingTimeId() {
        return workingTimeId;
    }

    public void setWorkingTimeId(Long workingTimeId) {
        this.workingTimeId = workingTimeId;
    }

    public String getVacanciesName() {
        return vacanciesName;
    }

    public void setVacanciesName(String vacanciesName) {
        this.vacanciesName = vacanciesName;
    }

    public String getWorkingTimeName() {
        return workingTimeName;
    }

    public void setWorkingTimeName(String workingTimeName) {
        this.workingTimeName = workingTimeName;
    }
}