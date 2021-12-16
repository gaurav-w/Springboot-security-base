package com.parkingbooking.parkingbookingv1.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	String username;
	String password;
	String role;

	public User(String user, String pass, String role) {
		this.username = user;
		this.password = pass;
		this.role = role;
	}

	public User() {

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
