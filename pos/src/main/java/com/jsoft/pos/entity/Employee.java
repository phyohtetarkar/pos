package com.jsoft.pos.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@SuppressWarnings("serial")
@Entity
public class Employee extends Person implements Serializable {

	public enum Role {
		ADMIN, LEADER, STAFF
	}

	@Column(unique = true)
	private String loginId;
	private String password;
	@Enumerated(STRING)
	private Role role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}