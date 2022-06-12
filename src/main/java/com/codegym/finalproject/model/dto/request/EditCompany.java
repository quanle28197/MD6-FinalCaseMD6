package com.codegym.finalproject.model.dto.request;

import com.codegym.finalproject.model.entity.City;

public class EditCompany {
    private String name;
    private String avatar;
    private String description;
    private String address;
    private Integer employeeQuantity;
    private City city;
    private String linkMap;
    private String phone;

    public EditCompany(String name, String avatar, String description, String address, Integer employeeQuantity, City city, String linkMap, String phone) {
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.address = address;
        this.employeeQuantity = employeeQuantity;
        this.city = city;
        this.linkMap = linkMap;
        this.phone = phone;
    }

    public EditCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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

    public Integer getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(Integer employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
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
}
