package com.oguztasgin.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String cinsiyet;

	@Embedded
	private ContactPerson contactPerson;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String email, String cinsiyet, ContactPerson contactPerson) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cinsiyet = cinsiyet;
		this.contactPerson = contactPerson;
	}

	public Student(int id, String firstName, String lastName, String email, String cinsiyet,
			ContactPerson contactPerson) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cinsiyet = cinsiyet;
		this.contactPerson = contactPerson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cinsiyet=" + cinsiyet + ", contactPerson=" + contactPerson + "]";
	}

}
