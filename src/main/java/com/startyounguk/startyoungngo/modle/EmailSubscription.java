package com.startyounguk.startyoungngo.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_subscription")
public class EmailSubscription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "emailId")
	private String emailString;
	
	public EmailSubscription() {
		
	}

	public EmailSubscription(String emailString) {
		this.emailString = emailString;
	}

	public int getId() {
		return id;
	}


	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	
	
}
