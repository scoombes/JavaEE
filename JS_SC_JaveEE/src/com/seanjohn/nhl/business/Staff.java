/*
 *   Document   : Staff.java
 *   Created on : July 23, 2016
 *   Authors    : John Steel & Sean Coombes
 */

package com.seanjohn.nhl.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long staffId;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state_province;
	private String postalCode;
	private String country;
	private String phone;
	private String mobile;
	private String email;
	private String certification;
	@OneToMany
	private List<Team> team;

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
