package com.cacttuseducation2020_2021.models;

public class Company {

    private int companyImage;
    private String companyName;
    private String companyValue;

    public Company(int companyImage, String companyName, String companyValue) {
        this.companyImage = companyImage;
        this.companyName = companyName;
        this.companyValue = companyValue;
    }

    public int getCompanyImage() {
        return companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyValue() {
        return companyValue;
    }
}
