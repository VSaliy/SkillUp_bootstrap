package com.packt.ch04.pojo;

public class Contact {
	private String firstName, lastName;
	private int gender;
	private String address;
	private String email;
	private String phone_number;

	// public Contact() {
	// // TODO Auto-generated constructor stub
	// firstName = "Kabir";
	// lastName = "Sohani";
	// address = "Pune";
	// gender =1;
	// email = "sohani@gmail.com";
	// }

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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

}
