package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Player implements Serializable {
  private Long playerid;
  private String lastname;
  private String firstname;
  private Double height;
  private Double weight;
  private java.sql.Date dob;
  private String school;
  private String streetaddress;
  private String city;
  private String state_province;
  private String postalcode;
  private String country;
  private String phone;
  private String mobile;
  private String email;

  public Long getPlayerid() {
    return playerid;
  }

  public void setPlayerid(Long playerid) {
    this.playerid = playerid;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public java.sql.Date getDob() {
    return dob;
  }

  public void setDob(java.sql.Date dob) {
    this.dob = dob;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getStreetaddress() {
    return streetaddress;
  }

  public void setStreetaddress(String streetaddress) {
    this.streetaddress = streetaddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState_province() {
    return state_province;
  }

  public void setState_province(String state_province) {
    this.state_province = state_province;
  }

  public String getPostalcode() {
    return postalcode;
  }

  public void setPostalcode(String postalcode) {
    this.postalcode = postalcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
