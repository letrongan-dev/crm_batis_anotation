package com.crm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
	
	private int id;
	@NotEmpty(message = "Tên không được để trống")
	private String name;
	@Email
	@NotEmpty(message = "Email không được để trống")
	private String email;
	@NotEmpty(message = "Password không được để trống")
	private String password;
	@NotEmpty(message = "Email không được để trống")
	private String role;
	
	public UserDto() {}

	public UserDto(int id, String name, String email, String password, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
