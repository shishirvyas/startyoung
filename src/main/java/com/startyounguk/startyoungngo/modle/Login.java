package com.startyounguk.startyoungngo.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="login") 
@Getter
@Setter
public class Login {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String gender;
	@Column
	private String username;
	@Column
	private String pwd;
	@Column
	private String user_role;
	
	

}
