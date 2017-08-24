package com.packt.ch04.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="contact_hib")
public class Contact {
	@NotEmpty
	@Length(min=2,max=10)
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotEmpty
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="GENDER")
	private int gender;
	
	@NotEmpty
	@Column(name="ADDRESS")
	private String address;

	@NotEmpty
	@Email(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
	@Id
	@Column(name="EMAIL")
	private String email;
	
	@NotEmpty
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="PHONENUMBER")
	private String phone_number;

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
