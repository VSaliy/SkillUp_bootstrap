package com.packt.ch04.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class Contact {
	@NotEmpty
	@Length(min=2,max=10)
	private String firstName;
	@NotEmpty
	private String lastName;

	private int gender;
	@NotEmpty
	private String address;

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phone_number;

	// public Contact() {
	// // TODO Auto-generated constructor stub
	// firstName = "Kabir";
	// lastName = "Sohani";
	// address = "Pune";
	// gender =1;
	// email = "sohani@gmail.com";
	// }

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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
