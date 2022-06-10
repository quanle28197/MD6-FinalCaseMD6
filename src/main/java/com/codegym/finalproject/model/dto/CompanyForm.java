package com.codegym.finalproject.model.dto;

import com.codegym.finalproject.model.entity.Account;
import com.codegym.finalproject.model.entity.City;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.model.entity.Status;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class CompanyForm {
    private Long id;

    private String codeCompany;

    private String name;

    private MultipartFile avatar;

    private String description;

    private String address;

    private int emplployeeQuantity;

    private City city;

    private String linkMap;

    private String phone;

    private Status statusCompany;

    private Account account;

    private List<RecuitmentNew> recuitmentNews;

    public CompanyForm() {
    }

    public CompanyForm(Long id, String codeCompany, String name, MultipartFile avatar, String description, String address, int emplployeeQuantity, City city, String linkMap, String phone, Status statusCompany, Account account, List<RecuitmentNew> recuitmentNews) {
        this.id = id;
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

    public CompanyForm(String codeCompany, String name, MultipartFile avatar, String description, String address, int emplployeeQuantity, City city, String linkMap, String phone, Status statusCompany, Account account, List<RecuitmentNew> recuitmentNews) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmplployeeQuantity() {
        return emplployeeQuantity;
    }

    public void setEmplployeeQuantity(int emplployeeQuantity) {
        this.emplployeeQuantity = emplployeeQuantity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatusCompany() {
        return statusCompany;
    }

    public void setStatusCompany(Status statusCompany) {
        this.statusCompany = statusCompany;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<RecuitmentNew> getRecuitmentNews() {
        return recuitmentNews;
    }

    public void setRecuitmentNews(List<RecuitmentNew> recuitmentNews) {
        this.recuitmentNews = recuitmentNews;
    }
}
