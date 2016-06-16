package com.seanjohn.nhl.business;

import java.io.Serializable;

public class Arena implements Serializable{
  private Long arenaid;
  private String arenaname;
  private String streetaddress;
  private String city;
  private String state_province;
  private String postalcode;
  private String country;
  private String phone;
  private Long capacity;

  public Long getArenaid() {
    return arenaid;
  }

  public void setArenaid(Long arenaid) {
    this.arenaid = arenaid;
  }

  public String getArenaname() {
    return arenaname;
  }

  public void setArenaname(String arenaname) {
    this.arenaname = arenaname;
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

  public Long getCapacity() {
    return capacity;
  }

  public void setCapacity(Long capacity) {
    this.capacity = capacity;
  }
}
