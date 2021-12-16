package com.parkingbooking.parkingbookingv1.domain;

public enum Role {

	USER("USER"), ADMIN("ADMIN");

	String val;

	Role(String value) {
		this.val = value;
	}
}
