package com.ind.lms.models;

public class Address {

    String city;
    String state;

    String pinCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Address city(String city){
        this.city = city;
        return this;

    }

    public Address state(String state){
        this.state = state;
        return this;

    }
    public Address pinCode(String pinCode){
        this.pinCode = pinCode;
        return this;
    }
}
