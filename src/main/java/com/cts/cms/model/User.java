package com.cts.cms.model;

public class User {
	private int id;
	private String userName;
	private String contactNumber;
	private String email;
	private String password;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int id, String userName, String contactNumber, String email, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}

}