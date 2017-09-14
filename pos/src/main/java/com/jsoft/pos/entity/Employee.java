package com.jsoft.pos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@SuppressWarnings("serial")
@Entity
public class Employee extends Person implements Serializable {

	public enum Role {
		ADMIN, LEADER, STAFF
	}

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