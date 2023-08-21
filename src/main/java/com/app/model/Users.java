package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Users {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "user_name", length = 20, unique = true)
	@NotBlank(message = "Name is required")
	@Length(min = 3, max = 50, message = "Length should be between 3 to 50 characters")
	private String userName;
	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	private Role userRole;
	@Column(unique = true)
	@NotBlank(message = "Email is required")
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(name = "phone_number", nullable = false)
	@NotBlank(message = "phone number is required")
	private String phoneNumber;
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column
	private String address;
	@Column(name = "login_attempt")
	private int loginAttempt;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(Integer userId,
			@NotBlank(message = "Name is required") @Length(min = 3, max = 50, message = "Length should be between 3 to 50 characters") String userName,
			Role userRole, @NotBlank(message = "Email is required") String email, String password,
			@NotBlank(message = "phone number is required") String phoneNumber, Gender gender, String address,
			int loginAttempt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.loginAttempt = loginAttempt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", address=" + address + ", loginAttempt="
				+ loginAttempt + "]";
	}

}
