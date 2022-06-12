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
}
