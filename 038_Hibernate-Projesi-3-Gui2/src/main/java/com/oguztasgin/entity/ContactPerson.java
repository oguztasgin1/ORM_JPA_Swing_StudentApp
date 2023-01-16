package com.oguztasgin.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ContactPerson {
	
	private String phoneNumber1;
	private String address1;
	private String phoneNumber2;
	private String address2;
	
	public ContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactPerson(String phoneNumber1, String address1, String phoneNumber2, String address2) {
		super();
		this.phoneNumber1 = phoneNumber1;
		this.address1 = address1;
		this.phoneNumber2 = phoneNumber2;
		this.address2 = address2;
	}
	
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "ContactPerson [phoneNumber1=" + phoneNumber1 + ", address1=" + address1 + ", phoneNumber2="
				+ phoneNumber2 + ", address2=" + address2 + "]";
	}

}
