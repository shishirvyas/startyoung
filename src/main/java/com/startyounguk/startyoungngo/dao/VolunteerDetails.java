package com.startyounguk.startyoungngo.dao;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "volunteer_details")
public class VolunteerDetails {
	
	@Id
	private String mobileNumber;
	@Column(name = "")
	private String firstName;
	@Column(name = "")
	private String lastName;
	@Column(name = "")
	private String email;
	@Column(name = "")
	private String type;
	
	public VolunteerDetails() {
		
	}
	
	
	public VolunteerDetails(String mobileNumber, String firstName, String lastName, String email, String type) {
		super();
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
