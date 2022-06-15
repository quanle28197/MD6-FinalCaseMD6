package com.codegym.finalproject.model.dto.request;

public class SearchJob {
    private String title;

    private Long cityId;

    private Long fieldId;

    private Long companyId;

    private Long vacancies;

    private Long  workingTimeId;

    private Integer start;

    private Integer pageSize;

    private Integer salary;

    public SearchJob() {
    }

    public SearchJob(String field) {
        this.title = field;
    }

    public SearchJob(String title, Long cityId, Long fieldId, Long companyId, Long vacancies, Long workingTimeId) {
        this.title = title;
        this.cityId = cityId;
        this.fieldId = fieldId;
        this.companyId = companyId;
        this.vacancies = vacancies;
        this.workingTimeId = workingTimeId;
    }

    public SearchJob(String title, Long cityId, Long fieldId, Long companyId, Long vacancies, Long workingTimeId, Integer start, Integer pageSize, Integer salary) {
        this.title = title;
        this.cityId = cityId;
        this.fieldId = fieldId;
        this.companyId = companyId;
        this.vacancies = vacancies;
        this.workingTimeId = workingTimeId;
        this.start = start;
        this.pageSize = pageSize;
        this.salary = salary;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getVacancies() {
        return vacancies;
    }

    public void setVacancies(Long vacancies) {
        this.vacancies = vacancies;
    }

    public Long getWorkingTimeId() {
        return workingTimeId;
    }

    public void setWorkingTimeId(Long workingTimeId) {
        this.workingTimeId = workingTimeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
