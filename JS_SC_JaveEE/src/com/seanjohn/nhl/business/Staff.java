package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Staff implements Serializable {
  private Long staffid;
  private String lastname;
  private String firstname;
  private String streetaddress;
  private String city;
  private String state_province;
  private String postalcode;
  private String country;
  private String phone;
  private String mobile;
  private String email;
  private String certification;

  public Long getStaffid() {
    return staffid;
  }

  public void setStaffid(Long staffid) {
    this.staffid = staffid;
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

  public String getCertification() {
    return certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }
}
