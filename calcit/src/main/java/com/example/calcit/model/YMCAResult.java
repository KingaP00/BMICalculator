package com.example.calcit.model;

public class YMCAResult {

    private double waistCircumference;
    private double weight;
    private double value;
    private String status;
    private String sex;

    public double getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(double waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex= sex;
    }
}